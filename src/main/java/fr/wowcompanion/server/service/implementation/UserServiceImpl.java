package fr.wowcompanion.server.service.implementation;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.server.dto.UserDTOBuilder;
import fr.wowcompanion.server.model.UserAccount;
import fr.wowcompanion.server.repository.UserAccountRepository;
import fr.wowcompanion.server.service.UserService;
import fr.wowcompanion.server.tools.oauth2.AuthenticationFacade;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final UserDTOBuilder USER_DTO_BUILDER = new UserDTOBuilder();
    
    private AuthenticationFacade authenticationFacade;
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserServiceImpl(final AuthenticationFacade authenticationFacade, final UserAccountRepository userAccountRepository){
        this.authenticationFacade = authenticationFacade;
        this.userAccountRepository = userAccountRepository;
    }



    @Override
    public UserDTO getUser() {
        UserAccount userAccount = this.authenticationFacade.getUserAccount();
        userAccount.setLastLoginInstant(Instant.now());
        userAccount = this.userAccountRepository.save(userAccount);
        return USER_DTO_BUILDER.transform(userAccount);
    }
    
}
