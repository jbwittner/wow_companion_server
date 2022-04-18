package fr.wowcompanion.server.tools.api.blizzardapi.callback;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import fr.jbwittner.blizzardswagger.wowretailapi.ApiCallback;
import fr.jbwittner.blizzardswagger.wowretailapi.ApiException;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterData;
import fr.wowcompanion.server.model.Character;
import fr.wowcompanion.server.model.PlayableClass;
import fr.wowcompanion.server.model.PlayableRace;
import fr.wowcompanion.server.model.PlayableSpecialization;
import fr.wowcompanion.server.model.Realm;
import fr.wowcompanion.server.repository.CharacterRepository;
import fr.wowcompanion.server.repository.CovenantRepository;
import fr.wowcompanion.server.repository.PlayableClassRepository;
import fr.wowcompanion.server.repository.PlayableRaceRepository;
import fr.wowcompanion.server.repository.PlayableSpecializationRepository;
import fr.wowcompanion.server.repository.RealmRepository;
import fr.wowcompanion.server.repository.UserAccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CharacterCallback extends CompletableFuture<CharacterData> implements ApiCallback<CharacterData>{

    protected static final Logger LOGGER = LoggerFactory.getLogger(CharacterCallback.class);

    protected final String characterName;
    protected final CharacterRepository characterRepository;
    protected final RealmRepository realmRepository;
    protected final PlayableClassRepository playableClassRepository;
    protected final PlayableRaceRepository playableRaceRepository;
    protected final CovenantRepository covenantRepository;
    protected final PlayableSpecializationRepository playableSpecializationRepository;
    protected final UserAccountRepository userAccountRepository;

    public CharacterCallback(final String characterName,
                            final CharacterRepository characterRepository,
                            final RealmRepository realmRepository,
                            final PlayableClassRepository playableClassRepository,
                            final PlayableRaceRepository playableRaceRepository,
                            final CovenantRepository covenantRepository,
                            final PlayableSpecializationRepository playableSpecializationRepository,
                            final UserAccountRepository userAccountRepository) {
        this.characterName = characterName;
        this.characterRepository = characterRepository;
        this.realmRepository = realmRepository;
        this.playableClassRepository = playableClassRepository;
        this.playableRaceRepository = playableRaceRepository;
        this.covenantRepository = covenantRepository;
        this.playableSpecializationRepository = playableSpecializationRepository;
        this.userAccountRepository = userAccountRepository;
                            }


    @Override
    public void onFailure(final ApiException e, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FAIL CharacterCallback : {} - {}", characterName, e.getMessage());
        super.complete(null);
    }

    @Override
    public void onSuccess(final CharacterData result, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("SUCESS CharacterCallback : {}", characterName);

        Optional<Character> optionalCharacter = this.characterRepository.findById(result.getId());

        Character character;

        if(optionalCharacter.isPresent()){
            character = optionalCharacter.get();
        } else {
            character = new Character();
            character.setId(result.getId());
        }

        character.setName(result.getName());

        PlayableRace playableRace = this.playableRaceRepository.findById(result.getRace().getId()).orElseThrow();
        character.setPlayableRace(playableRace);

        PlayableClass playableClass = this.playableClassRepository.findById(result.getCharacterClass().getId()).orElseThrow();
        character.setPlayableClass(playableClass);

        Realm realm = this.realmRepository.findBySlug(result.getRealm().getSlug()).orElseThrow();
        character.setRealm(realm);

        PlayableSpecialization playableSpecialization = this.playableSpecializationRepository.findById(result.getActiveSpec().getId()).orElseThrow();
        character.setMainPlayableSpecialization(playableSpecialization);

        this.characterRepository.save(character);
        
        super.complete(result);
        
    }

    @Override
    public void onUploadProgress(final long bytesWritten, final long contentLength, final boolean done) { 
        /* Don't need this part */
    }

    @Override
    public void onDownloadProgress(final long bytesRead, final long contentLength, final boolean done) {
        /* Don't need this part */
    }
    
}