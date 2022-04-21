package fr.wowcompanion.server.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.wowcompanion.openapi.model.StaticDataDTO;
import fr.wowcompanion.server.dto.CovenantDTOBuilder;
import fr.wowcompanion.server.dto.FactionDTOBuilder;
import fr.wowcompanion.server.dto.PlayableClassDTOBuilder;
import fr.wowcompanion.server.dto.PlayableRaceDTOBuilder;
import fr.wowcompanion.server.dto.PlayableSpecializationDTOBuilder;
import fr.wowcompanion.server.dto.RealmDTOBuilder;
import fr.wowcompanion.server.repository.CovenantRepository;
import fr.wowcompanion.server.repository.FactionRepository;
import fr.wowcompanion.server.repository.PlayableClassRepository;
import fr.wowcompanion.server.repository.PlayableRaceRepository;
import fr.wowcompanion.server.repository.PlayableSpecializationRepository;
import fr.wowcompanion.server.repository.RealmRepository;
import fr.wowcompanion.server.service.BlizzardDataService;

@Service
@Transactional
public class BlizzardDataServiceImpl implements BlizzardDataService{

    private RealmRepository realmRepository;
    private PlayableClassRepository playableClassRepository;
    private PlayableRaceRepository playableRaceRepository;
    private CovenantRepository covenantRepository;
    private PlayableSpecializationRepository playableSpecializationRepository;
    private FactionRepository factionRepository;

    private static final RealmDTOBuilder REALM_DTO_BUILDER = new RealmDTOBuilder();
    private static final PlayableClassDTOBuilder PLAYABLE_CLASS_DTO_BUILDER = new PlayableClassDTOBuilder();
    private static final PlayableRaceDTOBuilder PLAYABLE_RACE_DTO_BUILDER = new PlayableRaceDTOBuilder();
    private static final CovenantDTOBuilder COVENANT_DTO_BUILDER = new CovenantDTOBuilder();
    private static final PlayableSpecializationDTOBuilder PLAYABLE_SPECIALIZATION_DTO_BUILDER = new PlayableSpecializationDTOBuilder();
    private static final FactionDTOBuilder FACTION_DTO_BUILDER = new FactionDTOBuilder();

    @Autowired
    public BlizzardDataServiceImpl(RealmRepository realmRepository, PlayableClassRepository playableClassRepository,
            PlayableRaceRepository playableRaceRepository, CovenantRepository covenantRepository,
            PlayableSpecializationRepository playableSpecializationRepository, FactionRepository factionRepository) {
        this.realmRepository = realmRepository;
        this.playableClassRepository = playableClassRepository;
        this.playableRaceRepository = playableRaceRepository;
        this.covenantRepository = covenantRepository;
        this.playableSpecializationRepository = playableSpecializationRepository;
        this.factionRepository = factionRepository;
    }

    @Override
    public StaticDataDTO getStaticData() {
        final StaticDataDTO staticDataDTO = new StaticDataDTO();

        var realms = this.realmRepository.findAll();
        var realmDTOs = REALM_DTO_BUILDER.transformAll(realms);
        staticDataDTO.setRealmDTOs(realmDTOs);

        var playableClasses = this.playableClassRepository.findAll();
        var playableClassDTOs = PLAYABLE_CLASS_DTO_BUILDER.transformAll(playableClasses);
        staticDataDTO.setPlayableClassDTOs(playableClassDTOs);

        var playableRaces = this.playableRaceRepository.findAll();
        var playableRaceDTOs = PLAYABLE_RACE_DTO_BUILDER.transformAll(playableRaces);
        staticDataDTO.setPlayableRaceDTOs(playableRaceDTOs);

        var covenants = this.covenantRepository.findAll();
        var covenantDTOs = COVENANT_DTO_BUILDER.transformAll(covenants);
        staticDataDTO.setCovenantDTOs(covenantDTOs);

        var playableSpecializations = this.playableSpecializationRepository.findAll();
        var playableSpecializationDTOs = PLAYABLE_SPECIALIZATION_DTO_BUILDER.transformAll(playableSpecializations);
        staticDataDTO.setPlayableSpecializationDTOs(playableSpecializationDTOs);

        var factions = this.factionRepository.findAll();
        var factionDTOs = FACTION_DTO_BUILDER.transformAll(factions);
        staticDataDTO.setFactionDTOs(factionDTOs);

        return staticDataDTO;
    }
    
}
