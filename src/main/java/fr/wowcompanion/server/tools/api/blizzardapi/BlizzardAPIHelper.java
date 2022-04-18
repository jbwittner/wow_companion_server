package fr.wowcompanion.server.tools.api.blizzardapi;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.jbwittner.blizzardswagger.wowretailapi.ApiCallback;
import fr.jbwittner.blizzardswagger.wowretailapi.ApiClient;
import fr.jbwittner.blizzardswagger.wowretailapi.ApiException;
import fr.jbwittner.blizzardswagger.wowretailapi.Configuration;
import fr.jbwittner.blizzardswagger.wowretailapi.api.AccountProfileApi;
import fr.jbwittner.blizzardswagger.wowretailapi.api.CharacterProfileApi;
import fr.jbwittner.blizzardswagger.wowretailapi.auth.OAuth;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterData;
import fr.jbwittner.blizzardswagger.wowretailapi.model.ProfileAccountData;
import fr.wowcompanion.server.exception.BlizzardAPIException;
import fr.wowcompanion.server.tools.oauth2.AuthenticationFacade;
import fr.wowcompanion.server.tools.oauth2.BlizzardOAuth2FlowHandler;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Component
public class BlizzardAPIHelper {

    private String profileRegion;

    private OAuth oAuthSample;

    private AccountProfileApi accountProfileApi;
    private CharacterProfileApi characterProfileApi;

    @Autowired
    private BlizzardOAuth2FlowHandler blizzardOAuth2FlowHandler;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Value("${application.api.blizzard.region}")
    private String regionValue;

    @Value("${application.api.blizzard.timeout}")
    private Integer timeout;

    @PostConstruct
    private void init(){
        final String basePath = String.format("https://%s.api.blizzard.com", this.regionValue);

        this.profileRegion = String.format("profile-%s", this.regionValue);

        final ApiClient defaultClient = Configuration.getDefaultApiClient();
        final List<Interceptor> networkInterceptors = defaultClient.getHttpClient().networkInterceptors();

        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        for(final Interceptor interceptor : networkInterceptors){
            okHttpClientBuilder.addInterceptor(interceptor);
        }

        final BlizzardApiInterceptor blizzardApiInterceptor = new BlizzardApiInterceptor();
        okHttpClientBuilder.addInterceptor(blizzardApiInterceptor);

        okHttpClientBuilder.connectTimeout(this.timeout, TimeUnit.MILLISECONDS);
        final OkHttpClient httpClient = okHttpClientBuilder.build();

        defaultClient.setHttpClient(httpClient);
        defaultClient.setBasePath(basePath);

        this.oAuthSample = (OAuth) defaultClient.getAuthentication("oAuthAuthorizationCode");

        this.accountProfileApi = new AccountProfileApi(defaultClient);
        this.characterProfileApi = new CharacterProfileApi(defaultClient);
    }   

    private void updateServerToken() throws IOException{
        this.oAuthSample.setAccessToken(this.blizzardOAuth2FlowHandler.getToken());
    }

    private void updateUserToken(){
        this.oAuthSample.setAccessToken(this.authenticationFacade.getUserToken());
    }

    public ProfileAccountData getProfileAccountData() {
        try {
            this.updateUserToken();
            return this.accountProfileApi.getUserProfile(this.profileRegion, this.regionValue, "");
        } catch (ApiException e) {
            throw new BlizzardAPIException(e);
        }
    }

    public void getCharacterAsync(final String realmSlug, final String characterName, final ApiCallback<CharacterData> callback) {
        try {
            this.updateServerToken();
            this.characterProfileApi.getCharacterAsync(this.profileRegion, this.regionValue, realmSlug, characterName, "", callback);
        } catch (ApiException | IOException e) {
            throw new BlizzardAPIException(e);
        }
    }
}
