package fr.wowcompanion.server.service.authenticationservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.openapi.model.UserRegistrationParameter;
import fr.wowcompanion.server.exception.EmailAlreadyUsedException;
import fr.wowcompanion.server.exception.UserAlreadyRegistredException;
import fr.wowcompanion.server.exception.UserNameAlreadyUsedException;
import fr.wowcompanion.server.model.UserAccount;
import fr.wowcompanion.server.repository.UserAccountRepository;
import fr.wowcompanion.server.security.BlizzardDetail;
import fr.wowcompanion.server.service.implementation.AuthenticationServiceImpl;
import fr.wowcompanion.server.testhelper.AbstractMotherIntegrationTest;
import fr.wowcompanion.server.tools.oauth2.AuthenticationFacade;

class TestRegistration extends AbstractMotherIntegrationTest {

    @Mock
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private UserAccountRepository userAccountRepository;

    private AuthenticationServiceImpl authenticationServiceImpl;

    private UserRegistrationParameter userRegistrationParameter;
    private BlizzardDetail blizzardDetail;

    @Override
    protected void initDataBeforeEach() {
        this.authenticationServiceImpl = new AuthenticationServiceImpl(this.authenticationFacade, this.userAccountRepository);
        this.userRegistrationParameter = new UserRegistrationParameter();
        this.userRegistrationParameter.setEmail(this.testFactory.getUniqueRandomEmail());
        this.userRegistrationParameter.setUserName(this.testFactory.getRandomAlphanumericString());

        this.blizzardDetail = new BlizzardDetail();
        this.blizzardDetail.setBattleTag(this.testFactory.getRandomAlphanumericString());
        this.blizzardDetail.setBlizzardId(this.testFactory.getUniqueRandomInteger());
    }

    @Test
    void testRegistrationOk(){
        Mockito.when(this.authenticationFacade.getBlizzardDetail()).thenReturn(this.blizzardDetail);

        final UserDTO userDTO = this.authenticationServiceImpl.registration(this.userRegistrationParameter);

        Assertions.assertEquals(this.blizzardDetail.getBlizzardId(), userDTO.getBlizzardId());
        Assertions.assertEquals(this.blizzardDetail.getBattleTag(), userDTO.getBattletag());
        Assertions.assertEquals(this.userRegistrationParameter.getEmail(), userDTO.getEmail());
        Assertions.assertEquals(this.userRegistrationParameter.getUserName(), userDTO.getUserName());
        Assertions.assertFalse(userDTO.getIsAdmin());
    }

    @Test
    void testRegistrationBattleTagAlreadyUsed(){
        final UserAccount userAccount = this.testFactory.getUserAccount();
        this.blizzardDetail.setBattleTag(userAccount.getBattleTag());

        Mockito.when(this.authenticationFacade.getBlizzardDetail()).thenReturn(this.blizzardDetail);

        Assertions.assertThrows(UserAlreadyRegistredException.class, () -> {
            this.authenticationServiceImpl.registration(this.userRegistrationParameter);
        });
    }

    @Test
    void testRegistrationBlizzardIdAlreadyUsed(){
        final UserAccount userAccount = this.testFactory.getUserAccount();
        this.blizzardDetail.setBlizzardId(userAccount.getBlizzardId());

        Mockito.when(this.authenticationFacade.getBlizzardDetail()).thenReturn(this.blizzardDetail);

        Assertions.assertThrows(UserAlreadyRegistredException.class, () -> {
            this.authenticationServiceImpl.registration(this.userRegistrationParameter);
        });
    }

    @Test
    void testRegistrationEmailAlreadyUsed(){
        final UserAccount userAccount = this.testFactory.getUserAccount();
        this.userRegistrationParameter.setEmail(userAccount.getEmail());

        Mockito.when(this.authenticationFacade.getBlizzardDetail()).thenReturn(this.blizzardDetail);

        Assertions.assertThrows(EmailAlreadyUsedException.class, () -> {
            this.authenticationServiceImpl.registration(this.userRegistrationParameter);
        });
    }

    @Test
    void testRegistrationUserNameAlreadyUsed(){
        final UserAccount userAccount = this.testFactory.getUserAccount();
        this.userRegistrationParameter.setUserName(userAccount.getUserName());

        Mockito.when(this.authenticationFacade.getBlizzardDetail()).thenReturn(this.blizzardDetail);

        Assertions.assertThrows(UserNameAlreadyUsedException.class, () -> {
            this.authenticationServiceImpl.registration(this.userRegistrationParameter);
        });
    }
    
}
