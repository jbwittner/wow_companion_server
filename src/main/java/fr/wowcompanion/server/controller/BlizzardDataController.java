package fr.wowcompanion.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.wowcompanion.openapi.api.BlizzardDataApi;
import fr.wowcompanion.openapi.model.StaticDataDTO;
import fr.wowcompanion.server.service.BlizzardDataService;

@RestController
public class BlizzardDataController implements BlizzardDataApi {

    @Autowired
    private BlizzardDataService blizzardDataService;

    @Override
    public ResponseEntity<StaticDataDTO> getStaticData() {
        final StaticDataDTO staticDataDTO = this.blizzardDataService.getStaticData();
        return new ResponseEntity<>(staticDataDTO, HttpStatus.OK);
    }
    
}
