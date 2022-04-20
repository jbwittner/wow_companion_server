package fr.wowcompanion.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.wowcompanion.openapi.api.CharacterApi;
import fr.wowcompanion.openapi.model.CharacterDTO;
import fr.wowcompanion.server.service.CharacterService;

@RestController
public class CharacterController implements CharacterApi {
    
    @Autowired
    private CharacterService characterService;

    @Override
    public ResponseEntity<List<CharacterDTO>> fetchCharacters() {
        final List<CharacterDTO> characterArrayDTO = this.characterService.fetchCharacters();
        return new ResponseEntity<>(characterArrayDTO, HttpStatus.OK);
    }

}
