package fr.wowcompanion.server.service;

import java.util.List;

import fr.wowcompanion.openapi.model.CharacterDTO;

public interface CharacterService {
    
    List<CharacterDTO> fetchCharacters();

}
