package fr.wowcompanion.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.wowcompanion.openapi.api.UserApi;
import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.openapi.model.UserRegistrationParameter;
import fr.wowcompanion.server.service.UserService;


@RestController
public class UserController implements UserApi {
    
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDTO> userRegistration(final UserRegistrationParameter userRegistrationParameter){
        final UserDTO userDTO = this.userService.registration(userRegistrationParameter);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> getUser() {
        final UserDTO userDTO = this.userService.getUser();
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
