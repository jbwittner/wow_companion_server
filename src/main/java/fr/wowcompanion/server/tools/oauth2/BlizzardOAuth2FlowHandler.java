package fr.wowcompanion.server.tools.oauth2;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Service
public class BlizzardOAuth2FlowHandler {

    private static final Charset ENCODING = StandardCharsets.UTF_8;
    private final Object tokenLock = new Object();
    private static final Logger LOGGER = LoggerFactory.getLogger(BlizzardOAuth2FlowHandler.class);

    @Value("${spring.security.oauth2.client.registration.oauth-blizzard.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.oauth-blizzard.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.provider.blizzard.token-uri}")
    private String tokenUrl;

    private String token = null;
    private Instant tokenExpiry = null; // Instant when the token will expire

    public String getToken() throws IOException {

        if (this.isTokenInvalid()) {
            LOGGER.info("Fetching/Creating token.");

            final String encodedCredentials = Base64.getEncoder().encodeToString(String.format("%s:%s", this.clientId, this.clientSecret).getBytes(BlizzardOAuth2FlowHandler.ENCODING));

            final URL url = new URL(tokenUrl);

            final ObjectMapper objectMapper = new ObjectMapper();
            
            HttpURLConnection con = null;

            try {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Authorization", String.format("Basic %s", encodedCredentials));
                con.setDoOutput(true);
                con.getOutputStream().write("grant_type=client_credentials".getBytes(BlizzardOAuth2FlowHandler.ENCODING));

                final int responseCode = con.getResponseCode();
                LOGGER.info(String.format("Sent 'POST' to %s requesting access token via client credentials grant type.", url));
                LOGGER.info(String.format("Result code: %s", responseCode));

                final String response = IOUtils.toString(con.getInputStream(), BlizzardOAuth2FlowHandler.ENCODING);

                LOGGER.debug(String.format("Response: %s", response));

                // Reads the JSON response and converts
                // it to TokenResponse class or throws an exception
                final TokenResponse tokenResponse = objectMapper.readValue(response, TokenResponse.class);
                synchronized (tokenLock) {
                    tokenExpiry = Instant.now().plusSeconds(tokenResponse.getExpiresIn());
                    token = tokenResponse.getAccessToken();
                }

            } finally {
                if (con != null) {
                    con.disconnect();
                }
            }
        }
        synchronized (tokenLock) {
            LOGGER.debug("Use old token.");
            return token;
        }
    }

    public boolean isTokenInvalid() {
        boolean value;

        synchronized (tokenLock) {
            if (token == null) {
                value = true;
            } else if (tokenExpiry == null) {
                value = true;
            } else {
                value = Instant.now().isAfter(tokenExpiry);
            }
            return value;
        }
    }

}
