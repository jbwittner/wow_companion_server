package fr.wowcompanion.server.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterIndexData;
import fr.jbwittner.blizzardswagger.wowretailapi.model.ProfileAccountData;
import fr.wowcompanion.openapi.model.CharacterArrayDTO;
import fr.wowcompanion.server.service.CharacterService;
import fr.wowcompanion.server.tools.api.blizzardapi.BlizzardAPIHelper;
import fr.wowcompanion.server.tools.api.blizzardapi.callback.CharacterCallback;
import fr.wowcompanion.server.repository.CharacterRepository;
import fr.wowcompanion.server.repository.CovenantRepository;
import fr.wowcompanion.server.repository.PlayableClassRepository;
import fr.wowcompanion.server.repository.PlayableRaceRepository;
import fr.wowcompanion.server.repository.PlayableSpecializationRepository;
import fr.wowcompanion.server.repository.RealmRepository;
import fr.wowcompanion.server.repository.UserAccountRepository;


@Service
public class CharacterServiceImpl implements CharacterService {

    protected BlizzardAPIHelper blizzardAPIHelper;
    private CharacterRepository characterRepository;
    private RealmRepository realmRepository;
    private PlayableClassRepository playableClassRepository;
    private PlayableRaceRepository playableRaceRepository;
    private CovenantRepository covenantRepository;
    private PlayableSpecializationRepository playableSpecializationRepository;
    private UserAccountRepository userAccountRepository;


    @Autowired
    public CharacterServiceImpl(final BlizzardAPIHelper blizzardAPIHelper,
                                final CharacterRepository characterRepository,
                                final RealmRepository realmRepository,
                                final PlayableClassRepository playableClassRepository,
                                final PlayableRaceRepository playableRaceRepository,
                                final CovenantRepository covenantRepository,
                                final PlayableSpecializationRepository playableSpecializationRepository,
                                final UserAccountRepository userAccountRepository){
        this.blizzardAPIHelper = blizzardAPIHelper;
        this.characterRepository = characterRepository;
        this.realmRepository = realmRepository;
        this.playableClassRepository = playableClassRepository;
        this.playableRaceRepository = playableRaceRepository;
        this.covenantRepository = covenantRepository;
        this.playableSpecializationRepository = playableSpecializationRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public CharacterArrayDTO fetchCharacters() {
        ProfileAccountData profileAccountData = blizzardAPIHelper.getProfileAccountData();

        List<CharacterIndexData> characterIndexDatas = new ArrayList<>();

        profileAccountData.getWowAccounts().stream().forEach(wowAccountData -> {
            characterIndexDatas.addAll(wowAccountData.getCharacters());
        });

        var toto = characterIndexDatas.stream().map(this::fetchCharacter).map(CharacterCallback::join).toList();

        return null;
    }

    private CharacterCallback fetchCharacter(final CharacterIndexData characterIndexData) {

        CharacterCallback characterCallback = new CharacterCallback(characterIndexData.getName(),
            this.characterRepository, this.realmRepository, this.playableClassRepository, this.playableRaceRepository,
            this.covenantRepository, this.playableSpecializationRepository, this.userAccountRepository);

        this.blizzardAPIHelper.getCharacterAsync(characterIndexData.getRealm().getSlug(), characterIndexData.getName(), characterCallback);
        
        return null;
    }

}
