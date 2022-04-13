package fr.wowcompanion.server.tools.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import fr.wowcompanion.server.model.UserAccount;
import fr.wowcompanion.server.repository.UserAccountRepository;
import fr.wowcompanion.server.security.BlizzardDetail;

@Component
public class AuthenticationFacade {

    public static final String ID_ATTRIBUTE_KEY = "id";
    public static final String BATTLETAG_ATTRIBUTE_KEY = "battletag";

    private UserAccountRepository userAccountRepository;
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @Autowired
    public AuthenticationFacade(final UserAccountRepository userAccountRepository, final OAuth2AuthorizedClientService oAuth2AuthorizedClientService){
        this.userAccountRepository = userAccountRepository;
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }

    public BlizzardDetail getBlizzardDetail() {
        final OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        final OAuth2User oAuth2User = authentication.getPrincipal();
        final Integer blizzardId = oAuth2User.getAttribute(ID_ATTRIBUTE_KEY);
        final String battleTag = oAuth2User.getAttribute(BATTLETAG_ATTRIBUTE_KEY);

        final BlizzardDetail blizzardDetail = new BlizzardDetail();
        blizzardDetail.setBattleTag(battleTag);
        blizzardDetail.setBlizzardId(blizzardId);

        return blizzardDetail;
    }

    public UserAccount getUserAccount() {
        final BlizzardDetail blizzardDetail = this.getBlizzardDetail();
        return this.userAccountRepository.findByBlizzardId(blizzardDetail.getBlizzardId()).orElseThrow();
    }

    public String getUserToken() {
        final OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        final OAuth2AuthorizedClient oAuth2AuthorizedClient = this.oAuth2AuthorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());
        return oAuth2AuthorizedClient.getAccessToken().getTokenValue();
    }

}
