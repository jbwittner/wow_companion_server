package fr.wowcompanion.server.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.wowcompanion.openapi.api.AuthenticationApi;
import fr.wowcompanion.openapi.model.UserRegistrationParameter;
import fr.wowcompanion.server.service.AuthenticationService;

@RestController
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public ResponseEntity<Void> testConnection() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> testRegistration() {
        final Boolean isRegistred = this.authenticationService.isRegistred();
        return new ResponseEntity<>(isRegistred, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> userRegistration(@Valid UserRegistrationParameter userRegistrationParameter) {
        // TODO Auto-generated method stub
        return AuthenticationApi.super.userRegistration(userRegistrationParameter);
    }
    
}
