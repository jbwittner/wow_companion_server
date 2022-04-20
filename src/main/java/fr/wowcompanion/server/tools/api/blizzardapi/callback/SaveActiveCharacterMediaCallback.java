package fr.wowcompanion.server.tools.api.blizzardapi.callback;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.jbwittner.blizzardswagger.wowretailapi.ApiCallback;
import fr.jbwittner.blizzardswagger.wowretailapi.ApiException;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterMediaData;
import fr.wowcompanion.server.model.Character;

public class SaveActiveCharacterMediaCallback extends CompletableFuture<Character> implements ApiCallback<CharacterMediaData> {
    
    protected static final Logger LOGGER = LoggerFactory.getLogger(SaveActiveCharacterMediaCallback.class);

    protected final Character character;

    public SaveActiveCharacterMediaCallback(final Character character){
        this.character = character;
    }


    @Override
    public void onFailure(final ApiException e, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FAIL SaveActiveCharacterMediaCallback : {} - {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode, e.getMessage());
        super.complete(null);
    }

    @Override
    public void onSuccess(CharacterMediaData result, int statusCode, Map<String, List<String>> responseHeaders) {
        LOGGER.info("SUCESS SaveActiveCharacterMediaCallback : {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode);

        if(result.getAssets() == null){
            this.character.setMediaAvatarURL(result.getAvatarUrl());
            this.character.setMediaInsetURL(result.getBustUrl());
            this.character.setMediaMainURL(result.getRenderUrl());
        } else {
            this.character.setMediaAvatarURL(result.getAssets().get(0).getValue().toString());
            this.character.setMediaInsetURL(result.getAssets().get(1).getValue().toString());
            this.character.setMediaMainURL(result.getAssets().get(2).getValue().toString());
        }

        LOGGER.info("ENDING SaveActiveCharacterMediaCallback : {} - {}", this.character.getName(), this.character.getRealm().getSlug());

        super.complete(this.character);
        
    }

    @Override
    public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
        /* Don't need this part */
    }

    @Override
    public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
        /* Don't need this part */
    }
    
}
