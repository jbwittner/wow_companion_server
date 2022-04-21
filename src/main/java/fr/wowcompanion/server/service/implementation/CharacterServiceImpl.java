package fr.wowcompanion.server.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterIndexData;
import fr.jbwittner.blizzardswagger.wowretailapi.model.ProfileAccountData;
import fr.wowcompanion.openapi.model.CharacterDTO;
import fr.wowcompanion.server.service.CharacterService;
import fr.wowcompanion.server.tools.api.blizzardapi.BlizzardAPIHelper;
import fr.wowcompanion.server.tools.api.blizzardapi.callback.SaveActiveCharacterCallback;
import fr.wowcompanion.server.tools.api.blizzardapi.callback.SaveActiveCharacterMediaCallback;
import fr.wowcompanion.server.dto.CharacterDTOBuilder;
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
@Transactional
public class CharacterServiceImpl implements CharacterService {

    private static final CharacterDTOBuilder CHARACTER_DTO_BUILDER = new CharacterDTOBuilder();

    private BlizzardAPIHelper blizzardAPIHelper;
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
    public List<CharacterDTO> fetchCharacters() {

        ProfileAccountData profileAccountData = blizzardAPIHelper.getProfileAccountData();

        List<CharacterIndexData> characterIndexDatas = new ArrayList<>();

        profileAccountData.getWowAccounts().stream().forEach(wowAccountData -> characterIndexDatas.addAll(wowAccountData.getCharacters()));

        final List<Character> characters = characterIndexDatas.stream()
                                                                .map(this::saveCharacterIndex)
                                                                .toList();

        characters.stream()
                .map(this::fetchCharacter)
                .toList()
                .stream()
                .map(SaveActiveCharacterCallback::join)
                .toList()
                .stream()
                .filter(Objects::nonNull)
                .map(this::fetchCharacterMedia)
                .toList()
                .stream()
                .forEach(SaveActiveCharacterMediaCallback::join);



        final List<Character> savedCharacters = this.characterRepository.saveAll(characters);
        
        return CHARACTER_DTO_BUILDER.transformAll(savedCharacters);
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
        
        return character;

    }

    private SaveActiveCharacterCallback fetchCharacter(final Character character) {

        SaveActiveCharacterCallback saveActiveCharacterCallback = new SaveActiveCharacterCallback(character,
            this.realmRepository, this.playableClassRepository, this.playableRaceRepository,
            this.covenantRepository, this.playableSpecializationRepository, this.userAccountRepository);

        this.blizzardAPIHelper.getCharacterAsync(character.getRealm().getSlug(), character.getName(), saveActiveCharacterCallback);

        return saveActiveCharacterCallback;
    }

    private SaveActiveCharacterMediaCallback fetchCharacterMedia(final Character character) {
        SaveActiveCharacterMediaCallback saveActiveCharacterMediaCallback = new SaveActiveCharacterMediaCallback(character);
        this.blizzardAPIHelper.getCharacterMediaAsync(character.getRealm().getSlug(), character.getName(), saveActiveCharacterMediaCallback);
        return saveActiveCharacterMediaCallback;
    }

}
