package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.CharacterDTO;
import fr.wowcompanion.openapi.model.CovenantDTO;
import fr.wowcompanion.openapi.model.CovenantProgressDTO;
import fr.wowcompanion.openapi.model.GuildIndexDTO;
import fr.wowcompanion.openapi.model.PlayableClassDTO;
import fr.wowcompanion.openapi.model.PlayableRaceDTO;
import fr.wowcompanion.openapi.model.RealmDTO;
import fr.wowcompanion.server.model.Character;

public class CharacterDTOBuilder implements Transformer<Character, CharacterDTO> {

    private static final GuildIndexDTOBuilder GUILD_INDEX_DTO_BUILDER = new GuildIndexDTOBuilder();
    private static final RealmDTOBuilder REALM_DTO_BUILDER = new RealmDTOBuilder();
    private static final PlayableClassDTOBuilder PLAYABLE_CLASS_DTO_BUILDER = new PlayableClassDTOBuilder();
    private static final PlayableRaceDTOBuilder PLAYABLE_RACE_DTO_BUILDER = new PlayableRaceDTOBuilder();
    private static final CovenantDTOBuilder COVENANT_DTO_BUILDER = new CovenantDTOBuilder();

    @Override
    public CharacterDTO transform(final Character input) {
        final CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(input.getId());
        characterDTO.setName(input.getName());

        if(input.getGuild() != null){
            final GuildIndexDTO guildIndexDTO = GUILD_INDEX_DTO_BUILDER.transform(input.getGuild());
            characterDTO.setGuildIndexDTO(guildIndexDTO);
        }

        final RealmDTO realmDTO = REALM_DTO_BUILDER.transform(input.getRealm());
        characterDTO.setRealmDTO(realmDTO);

        final PlayableClassDTO playableClassDTO = PLAYABLE_CLASS_DTO_BUILDER.transform(input.getPlayableClass());
        characterDTO.setPlayableClassDTO(playableClassDTO);

        final PlayableRaceDTO playableRaceDTO = PLAYABLE_RACE_DTO_BUILDER.transform(input.getPlayableRace());
        characterDTO.setPlayableRaceDTO(playableRaceDTO);

        
        if(input.getCovenant() != null){
            final CovenantProgressDTO covenantProgressDTO = new CovenantProgressDTO();
            final CovenantDTO covenantDTO = COVENANT_DTO_BUILDER.transform(input.getCovenant());
            covenantProgressDTO.setCovenantDTO(covenantDTO);
            covenantProgressDTO.setRenownLevel(input.getRenownLevel());
            characterDTO.setCovenantProgressDTO(covenantProgressDTO);
        }
        
        characterDTO.setIsFavorite(input.isFavorite());
        characterDTO.setAverageItemLevel(input.getAverageItemLevel());
        characterDTO.setEquippedItemLevel(input.getEquippedItemLevel());
        characterDTO.lastLoginTimestamp(input.getLastLoginTimestamp());
        characterDTO.setLevel(input.getLevel());
        characterDTO.setIsActive(input.isActive());

        characterDTO.setMediaAvatarURL(input.getMediaAvatarURL());
        characterDTO.setMediaInsetURL(input.getMediaInsetURL());
        characterDTO.setMediaMainURL(input.getMediaMainURL());

        return characterDTO;
    }
    
}
