package fr.wowcompanion.server.service;

import fr.wowcompanion.openapi.model.CharacterArrayDTO;

public interface CharacterService {
    
    CharacterArrayDTO fetchCharacters();

}
