package fr.wowcompanion.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.wowcompanion.openapi.api.CharacterApi;
import fr.wowcompanion.openapi.model.CharacterArrayDTO;
import fr.wowcompanion.server.service.CharacterService;

@RestController
public class CharacterController implements CharacterApi {
    
    @Autowired
    private CharacterService characterService;

    @Override
    public ResponseEntity<CharacterArrayDTO> fetchCharacters() {
        final CharacterArrayDTO characterArrayDTO = this.characterService.fetchCharacters();
        return new ResponseEntity<>(characterArrayDTO, HttpStatus.OK);
    }

}
