package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.RealmCategoryDTO;
import fr.wowcompanion.server.model.RealmCategory;

public class RealmCategoryDTOBuilder implements Transformer<RealmCategory, RealmCategoryDTO> {

    @Override
    public RealmCategoryDTO transform(final RealmCategory input) {
        final RealmCategoryDTO realmCategoryDTO = new RealmCategoryDTO();
        realmCategoryDTO.setId(input.getId());
        realmCategoryDTO.setSlug(input.getSlug());

        realmCategoryDTO.setLocalizedData(input.getLocalizedModel().getLocalizedData());

        return realmCategoryDTO;
    }
    
}
