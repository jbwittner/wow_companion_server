package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.PlayableSpecializationDTO;
import fr.wowcompanion.openapi.model.SpecializationRoleDTO;
import fr.wowcompanion.server.model.PlayableSpecialization;

public class PlayableSpecializationDTOBuilder implements Transformer<PlayableSpecialization, PlayableSpecializationDTO> {

    private static final SpecializationRoleDTOBuilder SPECIALIZATION_ROLE_DTO_BUILDER = new SpecializationRoleDTOBuilder();

    @Override
    public PlayableSpecializationDTO transform(final PlayableSpecialization input) {
        final PlayableSpecializationDTO playableSpecializationDTO = new PlayableSpecializationDTO();
        playableSpecializationDTO.setId(input.getId());
        playableSpecializationDTO.setMediaURL(input.getMediaURL());
        
        final SpecializationRoleDTO specializationRoleDTO = SPECIALIZATION_ROLE_DTO_BUILDER.transform(input.getSpecializationRole());
        playableSpecializationDTO.setSpecializationRoleDTO(specializationRoleDTO);

        playableSpecializationDTO.setLocalizedData(input.getLocalizedModel().getLocalizedData());
        playableSpecializationDTO.setPlayableClassId(input.getPlayableClass().getId());

        return playableSpecializationDTO;
    }

}
