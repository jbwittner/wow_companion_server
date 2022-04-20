package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.RealmCategoryDTO;
import fr.wowcompanion.openapi.model.RealmDTO;
import fr.wowcompanion.server.model.Realm;

public class RealmDTOBuilder implements Transformer<Realm, RealmDTO> {

    private static final RealmCategoryDTOBuilder REALM_CATEGORY_DTO_BUILDER = new RealmCategoryDTOBuilder();

    @Override
    public RealmDTO transform(final Realm input) {
        final RealmDTO realmDTO = new RealmDTO();
        realmDTO.setId(input.getId());
        realmDTO.setLocale(input.getLocale());
        realmDTO.setSlug(input.getSlug());
        realmDTO.setTimezone(input.getTimezone());

        final RealmCategoryDTO realmCategoryDTO = REALM_CATEGORY_DTO_BUILDER.transform(input.getRealmCategory());
        realmDTO.setRealmCategoryDTO(realmCategoryDTO);

        return realmDTO;
    }
    
}
