package fr.wowcompanion.server.tools.api.blizzardapi.callback;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import fr.jbwittner.blizzardswagger.wowretailapi.ApiCallback;
import fr.jbwittner.blizzardswagger.wowretailapi.ApiException;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterData;
import fr.wowcompanion.server.model.Character;
import fr.wowcompanion.server.model.Covenant;
import fr.wowcompanion.server.model.PlayableSpecialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SaveActiveCharacterCallback extends CompletableFuture<Character> implements ApiCallback<CharacterData>{

    protected static final Logger LOGGER = LoggerFactory.getLogger(SaveActiveCharacterCallback.class);

    private Character character;
    private List<Covenant> covenants;
    private List<PlayableSpecialization> playableSpecializations;

    public SaveActiveCharacterCallback(Character character, List<Covenant> covenants,
            List<PlayableSpecialization> playableSpecializations) {
        this.character = character;
        this.covenants = covenants;
        this.playableSpecializations = playableSpecializations;
    }

    @Override
    public void onFailure(final ApiException e, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FAIL SaveActiveCharacterCallback : {} - {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode, e.getMessage());
        super.complete(null);
    }

    @Override
    public void onSuccess(final CharacterData result, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("SUCESS SaveActiveCharacterCallback : {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode);

        if(this.character.getMainPlayableSpecialization() == null){
            var mainPlayableSpecialization = this.playableSpecializations.stream()
                                                    .filter(spec -> spec.getId().equals(result.getActiveSpec().getId()))
                                                    .findAny()
                                                    .orElseThrow();
            this.character.setMainPlayableSpecialization(mainPlayableSpecialization);
        }

        if(result.getCovenantProgress() != null){
            var covenant = this.covenants.stream()
                                            .filter(cov -> cov.getId().equals(result.getCovenantProgress().getChosenCovenant().getId()))
                                            .findAny()
                                            .orElseThrow();
            
            this.character.setCovenant(covenant);
            this.character.setRenownLevel(result.getCovenantProgress().getRenownLevel());
        }

        this.character.setEquippedItemLevel(result.getEquippedItemLevel());
        this.character.setAverageItemLevel(result.getAverageItemLevel());
        this.character.setIsActiveTrue();

        super.complete(this.character);
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