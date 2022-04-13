package fr.wowcompanion.server.service.implementation;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.openapi.model.UserRegistrationParameter;
import fr.wowcompanion.server.dto.UserDTOBuilder;
import fr.wowcompanion.server.exception.EmailAlreadyUsedException;
import fr.wowcompanion.server.exception.UserAlreadyRegistredException;
import fr.wowcompanion.server.exception.UserNameAlreadyUsedException;
import fr.wowcompanion.server.model.UserAccount;
import fr.wowcompanion.server.repository.UserAccountRepository;
import fr.wowcompanion.server.security.BlizzardDetail;
import fr.wowcompanion.server.service.UserService;
import fr.wowcompanion.server.tools.oauth2.AuthenticationFacade;

@Service
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
    public UserDTO registration(final UserRegistrationParameter userRegistrationParameter){
        final BlizzardDetail blizzardDetail = authenticationFacade.getBlizzardDetail();

        this.checkRegistration(blizzardDetail, userRegistrationParameter);

        UserAccount userAccount = new UserAccount();
        userAccount.setBattleTag(blizzardDetail.getBattleTag());
        userAccount.setBlizzardId(blizzardDetail.getBlizzardId());
        userAccount.setEmail(userRegistrationParameter.getEmail());
        userAccount.setUserName(userRegistrationParameter.getUserName());
        userAccount.setCreationInstant(Instant.now());
        userAccount.setLastLoginInstant(Instant.now());

        userAccount = userAccountRepository.save(userAccount);

        return USER_DTO_BUILDER.transform(userAccount);
    }

    private void checkRegistration(final BlizzardDetail blizzardDetail, final UserRegistrationParameter userRegistrationParameter){
        final boolean blizzardIdAlreadyUsed = this.userAccountRepository.existsByBlizzardId(blizzardDetail.getBlizzardId());
        final boolean battleTagAlreadyUsed = this.userAccountRepository.existsByBattleTag(blizzardDetail.getBattleTag());

        if(blizzardIdAlreadyUsed || battleTagAlreadyUsed){
            throw new UserAlreadyRegistredException(blizzardDetail.getBattleTag());
        }

        final boolean emailAlreadyUsed = this.userAccountRepository.existsByEmail(userRegistrationParameter.getEmail());
        final boolean userNameAlreadyUsed = this.userAccountRepository.existsByUserName(userRegistrationParameter.getUserName());

        if(emailAlreadyUsed) {
            throw new EmailAlreadyUsedException(userRegistrationParameter.getEmail());
        } else if(userNameAlreadyUsed){
            throw new UserNameAlreadyUsedException(userRegistrationParameter.getUserName());
        }
    }

    @Override
    public UserDTO getUser() {
        UserAccount userAccount = this.authenticationFacade.getUserAccount();
        userAccount.setLastLoginInstant(Instant.now());
        userAccount = this.userAccountRepository.save(userAccount);
        return USER_DTO_BUILDER.transform(userAccount);
    }
    
}
