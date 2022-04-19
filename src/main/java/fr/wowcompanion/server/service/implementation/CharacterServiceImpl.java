package fr.wowcompanion.server.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterData;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterIndexData;
import fr.jbwittner.blizzardswagger.wowretailapi.model.ProfileAccountData;
import fr.wowcompanion.openapi.model.CharacterArrayDTO;
import fr.wowcompanion.server.service.CharacterService;
import fr.wowcompanion.server.tools.api.blizzardapi.BlizzardAPIHelper;
import fr.wowcompanion.server.tools.api.blizzardapi.callback.SaveActiveCharacterCallback;
import fr.wowcompanion.server.tools.api.blizzardapi.callback.SaveActiveCharacterMediaCallback;
import fr.wowcompanion.server.model.Character;
import fr.wowcompanion.server.model.PlayableClass;
import fr.wowcompanion.server.model.PlayableRace;
import fr.wowcompanion.server.model.Realm;
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
        final long start = System.currentTimeMillis();

        ProfileAccountData profileAccountData = blizzardAPIHelper.getProfileAccountData();

        List<CharacterIndexData> characterIndexDatas = new ArrayList<>();

        profileAccountData.getWowAccounts().stream().forEach(wowAccountData -> {
            characterIndexDatas.addAll(wowAccountData.getCharacters());
        });

        var characters = characterIndexDatas.stream()
                            .map(this::saveCharacterIndex)
                            .collect(Collectors.toList());

        characters.stream()
                    .map(this::fetchCharacter)
                    .collect(Collectors.toList())
                    .stream()
                    .map(this::fetchCharacterMedia)
                    .collect(Collectors.toList())
                    .stream()
                    .forEach(CompletableFuture::join);

        final long executionTime = System.currentTimeMillis() - start;
        System.out.println("Ending call in " + executionTime + " ms");

        characters.stream().forEach(arr -> System.out.println(arr));

        return null;
    }

    private Character saveCharacterIndex(final CharacterIndexData characterIndexData) {
        Optional<Character> optionalCharacter = this.characterRepository.findById(characterIndexData.getId());
        
        Character character;

        if(optionalCharacter.isPresent()){
            character = optionalCharacter.get();
        } else {
            character = new Character();
            character.setId(characterIndexData.getId());
        }

        character.setName(characterIndexData.getName());

        PlayableRace playableRace = this.playableRaceRepository.getById(characterIndexData.getPlayableRace().getId());
        character.setPlayableRace(playableRace);

        PlayableClass playableClass = this.playableClassRepository.getById(characterIndexData.getPlayableClass().getId());
        character.setPlayableClass(playableClass);

        Realm realm = this.realmRepository.getBySlug(characterIndexData.getRealm().getSlug());
        character.setRealm(realm);

        character.setLevel(characterIndexData.getLevel());
        
        return this.characterRepository.save(character);

    }

    private SaveActiveCharacterCallback fetchCharacter(final Character character) {

        SaveActiveCharacterCallback saveActiveCharacterCallback = new SaveActiveCharacterCallback(character,
            this.characterRepository, this.realmRepository, this.playableClassRepository, this.playableRaceRepository,
            this.covenantRepository, this.playableSpecializationRepository, this.userAccountRepository);

        this.blizzardAPIHelper.getCharacterAsync(character.getRealm().getSlug(), character.getName(), saveActiveCharacterCallback);

        return saveActiveCharacterCallback;
    }

    private SaveActiveCharacterMediaCallback fetchCharacterMedia(final Character character) {
        if(character == null)
        SaveActiveCharacterMediaCallback saveActiveCharacterMediaCallback = new SaveActiveCharacterMediaCallback(character, this.characterRepository);
        this.blizzardAPIHelper.getCharacterMediaAsync(character.getRealm().getSlug(), character.getName(), saveActiveCharacterMediaCallback);
        return saveActiveCharacterMediaCallback;
    }

}
