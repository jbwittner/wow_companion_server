package fr.wowcompanion.server.dto;

import java.util.List;

import fr.wowcompanion.openapi.model.PlayableClassDTO;
import fr.wowcompanion.openapi.model.PlayableSpecializationDTO;
import fr.wowcompanion.server.model.PlayableClass;

public class PlayableClassDTOBuilder implements Transformer<PlayableClass, PlayableClassDTO> {

    private static final PlayableSpecializationDTOBuilder PLAYABLE_SPECIALIZATION_DTO_BUILDER = new PlayableSpecializationDTOBuilder();

    @Override
    public PlayableClassDTO transform(final PlayableClass input) {
        final PlayableClassDTO playableClassDTO = new PlayableClassDTO();
        playableClassDTO.setId(input.getId());
        playableClassDTO.setMediaURL(input.getMediaURL());
        playableClassDTO.setLocalizedData(input.getLocalizedModel().getLocalizedData());

        final List<PlayableSpecializationDTO> playableSpecializationDTOs = PLAYABLE_SPECIALIZATION_DTO_BUILDER.transformAll(input.getPlayableSpecializationList());
        playableClassDTO.setPlayableSpecializationDTOs(playableSpecializationDTOs);

        return playableClassDTO;
    }

}
