package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.CovenantDTO;
import fr.wowcompanion.server.model.Covenant;

public class CovenantDTOBuilder implements Transformer<Covenant, CovenantDTO> {

    @Override
    public CovenantDTO transform(final Covenant input) {
        final CovenantDTO covenantDTO = new CovenantDTO();
        covenantDTO.setId(input.getId());
        var toto = input.getLocalizedModel();
        System.out.println(toto);
        covenantDTO.setLocalizedData(input.getLocalizedModel().getLocalizedData());
        covenantDTO.setMediaURL(input.getMediaURL());
        return covenantDTO;
    }
    
}
