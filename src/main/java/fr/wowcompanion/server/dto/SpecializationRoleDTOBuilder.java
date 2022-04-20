package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.SpecializationRoleDTO;
import fr.wowcompanion.server.model.SpecializationRole;

public class SpecializationRoleDTOBuilder implements Transformer<SpecializationRole, SpecializationRoleDTO> {

    @Override
    public SpecializationRoleDTO transform(final SpecializationRole input) {
        final SpecializationRoleDTO specializationRoleDTO = new SpecializationRoleDTO();
        specializationRoleDTO.setId(input.getId());
        specializationRoleDTO.setType(input.getType());
        specializationRoleDTO.setLocalizedData(input.getLocalizedModel().getLocalizedData());
        return specializationRoleDTO;
    }

}
