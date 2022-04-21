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

    private String characterName;
    private String characterRealmSlug;

    public SaveActiveCharacterCallback(String characterName, String characterRealmSlug) {
        this.characterName = characterName;
        this.characterRealmSlug = characterRealmSlug;
    }


    @Override
    public void onFailure(final ApiException e, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FAIL SaveActiveCharacterCallback : {} - {} - {} - {}", this.characterName, this.characterRealmSlug, statusCode, e.getMessage());
        super.complete(null);
    }

    @Override
    public void onSuccess(final CharacterData result, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("SUCESS SaveActiveCharacterCallback : {} - {} - {}", this.characterName, this.characterRealmSlug, statusCode);
        
        super.complete(null);
        
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