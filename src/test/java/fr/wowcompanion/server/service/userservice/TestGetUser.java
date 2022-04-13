package fr.wowcompanion.server.service.userservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.server.model.UserAccount;
import fr.wowcompanion.server.repository.UserAccountRepository;
import fr.wowcompanion.server.service.implementation.UserServiceImpl;
import fr.wowcompanion.server.testhelper.AbstractMotherIntegrationTest;
import fr.wowcompanion.server.tools.oauth2.AuthenticationFacade;

public class TestGetUser extends AbstractMotherIntegrationTest {

    @Mock
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private UserAccountRepository userAccountRepository;

    private UserServiceImpl userServiceImpl;

    @Override
    protected void initDataBeforeEach() {
        this.userServiceImpl = new UserServiceImpl(this.authenticationFacade, this.userAccountRepository);
    }

    @Test
    public void testGetUser(){
        final UserAccount userAccount = this.testFactory.getUserAccount();
        Mockito.when(this.authenticationFacade.getUserAccount()).thenReturn(userAccount);

        final UserDTO userDTO = this.userServiceImpl.getUser();

        Assertions.assertEquals(userAccount.getBlizzardId(), userDTO.getBlizzardId());
        Assertions.assertEquals(userAccount.getBattleTag(), userDTO.getBattletag());
        Assertions.assertEquals(userAccount.getEmail(), userDTO.getEmail());
        Assertions.assertEquals(userAccount.getUserName(), userDTO.getUserName());
        Assertions.assertEquals(userAccount.isAdmin(), userDTO.getIsAdmin());
    }
    
}
