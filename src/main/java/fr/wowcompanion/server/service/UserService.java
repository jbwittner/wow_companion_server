package fr.wowcompanion.server.service;

import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.openapi.model.UserRegistrationParameter;

public interface UserService {

    UserDTO registration(UserRegistrationParameter userRegistrationParameter);
    
    UserDTO getUser();
    
}
