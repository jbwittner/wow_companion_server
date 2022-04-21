package fr.wowcompanion.server.tools.api.blizzardapi.callback;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import fr.jbwittner.blizzardswagger.wowretailapi.ApiCallback;
import fr.jbwittner.blizzardswagger.wowretailapi.ApiException;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterData;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CovenantProgressData;
import fr.wowcompanion.server.model.Character;
import fr.wowcompanion.server.model.Covenant;
import fr.wowcompanion.server.model.PlayableSpecialization;
import fr.wowcompanion.server.repository.CovenantRepository;
import fr.wowcompanion.server.repository.PlayableClassRepository;
import fr.wowcompanion.server.repository.PlayableRaceRepository;
import fr.wowcompanion.server.repository.PlayableSpecializationRepository;
import fr.wowcompanion.server.repository.RealmRepository;
import fr.wowcompanion.server.repository.UserAccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SaveActiveCharacterCallback extends CompletableFuture<Character> implements ApiCallback<CharacterData>{

    protected static final Logger LOGGER = LoggerFactory.getLogger(SaveActiveCharacterCallback.class);

    protected Character character;
    protected final RealmRepository realmRepository;
    protected final PlayableClassRepository playableClassRepository;
    protected final PlayableRaceRepository playableRaceRepository;
    protected final CovenantRepository covenantRepository;
    protected final PlayableSpecializationRepository playableSpecializationRepository;
    protected final UserAccountRepository userAccountRepository;

    public SaveActiveCharacterCallback(final Character character,
                            final RealmRepository realmRepository,
                            final PlayableClassRepository playableClassRepository,
                            final PlayableRaceRepository playableRaceRepository,
                            final CovenantRepository covenantRepository,
                            final PlayableSpecializationRepository playableSpecializationRepository,
                            final UserAccountRepository userAccountRepository) {
        this.character = character;
        this.realmRepository = realmRepository;
        this.playableClassRepository = playableClassRepository;
        this.playableRaceRepository = playableRaceRepository;
        this.covenantRepository = covenantRepository;
        this.playableSpecializationRepository = playableSpecializationRepository;
        this.userAccountRepository = userAccountRepository;
                            }


    @Override
    public void onFailure(final ApiException e, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FAIL SaveActiveCharacterCallback : {} - {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode, e.getMessage());
        super.complete(null);
    }

    @Override
    public void onSuccess(final CharacterData result, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("SUCESS SaveActiveCharacterCallback : {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode);

        character.setAverageItemLevel(result.getAverageItemLevel());
        character.setEquippedItemLevel(result.getEquippedItemLevel());

        character.setLastLoginTimestamp(result.getLastLoginTimestamp());

        CovenantProgressData covenantProgressData = result.getCovenantProgress();

        if(character.getMainPlayableSpecialization() == null){
            PlayableSpecialization playableSpecialization = this.playableSpecializationRepository.getById(result.getActiveSpec().getId());
            character.setMainPlayableSpecialization(playableSpecialization);
        }

        if(result.getCovenantProgress() != null) {
            Covenant covenant = this.covenantRepository.getById(covenantProgressData.getChosenCovenant().getId());
            character.setCovenant(covenant);
            character.setRenownLevel(covenantProgressData.getRenownLevel());
        }

        character.setIsActiveTrue();

        LOGGER.info("ENDING SaveActiveCharacterCallback : {} - {}", this.character.getName(), this.character.getRealm().getSlug());
        
        super.complete(character);
        
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