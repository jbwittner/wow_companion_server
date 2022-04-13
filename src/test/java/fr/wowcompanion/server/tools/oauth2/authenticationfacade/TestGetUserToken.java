package fr.wowcompanion.server.tools.oauth2.authenticationfacade;

import java.time.Instant;
import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType;
import org.springframework.security.oauth2.core.user.OAuth2User;

import fr.wowcompanion.server.repository.UserAccountRepository;
import fr.wowcompanion.server.testhelper.AbstractMotherIntegrationTest;
import fr.wowcompanion.server.tools.oauth2.AuthenticationFacade;

class TestGetUserToken extends AbstractMotherIntegrationTest{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Mock
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    private AuthenticationFacade authenticationFacade;

    @Override
    protected void initDataBeforeEach() {
        this.authenticationFacade = new AuthenticationFacade(this.userAccountRepository, this.oAuth2AuthorizedClientService);
    }

    @Test
    void testGetUserToken(){

        final String name = this.testFactory.getRandomAlphanumericString();
        final String authorizedClientRegistrationId = this.testFactory.getRandomAlphanumericString();
        final String tokenValue = this.testFactory.getRandomAlphanumericString();

        final OAuth2UserTest oAuth2User = new OAuth2UserTest();
        oAuth2User.setName(name);
        final OAuth2AuthenticationToken oAuth2AuthenticationToken = new OAuth2AuthenticationToken(oAuth2User, null, authorizedClientRegistrationId);

        final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(oAuth2AuthenticationToken);


        final OAuth2AccessToken oAuth2AccessToken = new OAuth2AccessToken(TokenType.BEARER,
                                                                        tokenValue,
                                                                        Instant.now(),
                                                                        Instant.MAX);

        final OAuth2AuthorizedClient oAuth2AuthorizedClient = Mockito.mock(OAuth2AuthorizedClient.class);
        Mockito.when(oAuth2AuthorizedClient.getAccessToken()).thenReturn(oAuth2AccessToken);

        Mockito.when(this.oAuth2AuthorizedClientService.loadAuthorizedClient(authorizedClientRegistrationId, name)).thenReturn(oAuth2AuthorizedClient);

        SecurityContextHolder.setContext(securityContext);

        final String userToken = this.authenticationFacade.getUserToken();

        Assertions.assertEquals(tokenValue, userToken);

    }

    class OAuth2UserTest implements OAuth2User {

        private String name;

        public void setName(final String name) {
            this.name = name;
        }

        @Override
        public Map<String, Object> getAttributes() {
            return null;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getName() {
            return this.name;
        }
        
    }
    
}
