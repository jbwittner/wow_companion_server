package fr.wowcompanion.server.service;

import java.util.List;

import fr.wowcompanion.openapi.model.CharacterArrayDTO;

public interface CharacterService {
    
    CharacterArrayDTO fetchCharacters();

}
