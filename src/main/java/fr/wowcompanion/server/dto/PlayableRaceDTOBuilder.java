package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.FactionDTO;
import fr.wowcompanion.openapi.model.PlayableRaceDTO;
import fr.wowcompanion.server.model.PlayableRace;

public class PlayableRaceDTOBuilder implements Transformer<PlayableRace, PlayableRaceDTO> {

    private static final FactionDTOBuilder FACTION_DTO_BUILDER = new FactionDTOBuilder();

    @Override
    public PlayableRaceDTO transform(final PlayableRace input) {
        final PlayableRaceDTO playableRaceDTO = new PlayableRaceDTO();
        playableRaceDTO.setId(input.getId());
        playableRaceDTO.setLocalizedData(input.getLocalizedModel().getLocalizedData());

        final FactionDTO factionDTO = FACTION_DTO_BUILDER.transform(input.getFaction());
        playableRaceDTO.setFactionDTO(factionDTO);

        return playableRaceDTO;
    }
    
}
