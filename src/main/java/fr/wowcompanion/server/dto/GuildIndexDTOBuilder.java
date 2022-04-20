package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.FactionDTO;
import fr.wowcompanion.openapi.model.GuildIndexDTO;
import fr.wowcompanion.openapi.model.RealmDTO;
import fr.wowcompanion.server.model.Guild;

public class GuildIndexDTOBuilder implements Transformer<Guild, GuildIndexDTO> {

    private static final FactionDTOBuilder FACTION_DTO_BUILDER = new FactionDTOBuilder();
    private static final RealmDTOBuilder REALM_DTO_BUILDER = new RealmDTOBuilder();

    @Override
    public GuildIndexDTO transform(final Guild input) {
        final GuildIndexDTO guildIndexDTO = new GuildIndexDTO();
        guildIndexDTO.setId(input.getId());
        guildIndexDTO.setName(input.getName());
        guildIndexDTO.setUseApplication(input.getUseApplication());

        final FactionDTO factionDTO = FACTION_DTO_BUILDER.transform(input.getFaction());
        guildIndexDTO.setFactionDTO(factionDTO);

        final RealmDTO realmDTO = REALM_DTO_BUILDER.transform(input.getRealm());
        guildIndexDTO.setRealmDTO(realmDTO);
        return guildIndexDTO;
    }
    
}
