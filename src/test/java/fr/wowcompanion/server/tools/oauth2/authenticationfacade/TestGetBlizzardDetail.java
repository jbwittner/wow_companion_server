package fr.wowcompanion.server.tools.oauth2.authenticationfacade;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

import fr.wowcompanion.server.repository.UserAccountRepository;
import fr.wowcompanion.server.security.BlizzardDetail;
import fr.wowcompanion.server.testhelper.AbstractMotherIntegrationTest;
import fr.wowcompanion.server.tools.oauth2.AuthenticationFacade;

class TestGetBlizzardDetail extends AbstractMotherIntegrationTest{

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
    void testGetBlizzardDetail(){

        final Integer blizzardId = this.testFactory.getRandomInteger();
        final String battleTag = this.testFactory.getRandomAlphanumericString();

        final Map<String, Object> attributes = new LinkedHashMap<>();
        attributes.put(AuthenticationFacade.ID_ATTRIBUTE_KEY, blizzardId);
        attributes.put(AuthenticationFacade.BATTLETAG_ATTRIBUTE_KEY, battleTag);

        final OAuth2UserTest oAuth2User = new OAuth2UserTest();
        oAuth2User.setAttributes(attributes);
        
        final OAuth2AuthenticationToken oAuth2AuthenticationToken = new OAuth2AuthenticationToken(oAuth2User, null, this.testFactory.getRandomAlphanumericString());

        final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(oAuth2AuthenticationToken);

        SecurityContextHolder.setContext(securityContext);

        final BlizzardDetail blizzardDetail = this.authenticationFacade.getBlizzardDetail();

        Assertions.assertEquals(blizzardId, blizzardDetail.getBlizzardId());
        Assertions.assertEquals(battleTag, blizzardDetail.getBattleTag());
    }

    class OAuth2UserTest implements OAuth2User {

        private Map<String, Object> attributes;

        public void setAttributes(final Map<String, Object> attributes){
            this.attributes = attributes;
        }

        @Override
        public Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
        
    }
}
