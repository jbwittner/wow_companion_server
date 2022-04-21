package fr.wowcompanion.server.service;

import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.openapi.model.UserRegistrationParameter;

public interface AuthenticationService {

    UserDTO registration(UserRegistrationParameter userRegistrationParameter);

    public Boolean isRegistred();
    
}
