package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.FactionDTO;
import fr.wowcompanion.server.model.Faction;

public class FactionDTOBuilder implements Transformer<Faction, FactionDTO> {

    @Override
    public FactionDTO transform(final Faction input) {
        final FactionDTO factionDTO = new FactionDTO();
        factionDTO.setId(input.getId());
        factionDTO.setType(input.getType());
        factionDTO.setLocalizedData(input.getLocalizedModel().getLocalizedData());
        return factionDTO;
    }
    
}
