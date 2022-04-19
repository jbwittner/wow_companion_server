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
import fr.wowcompanion.server.repository.CharacterRepository;

public class SaveActiveCharacterMediaCallback extends CompletableFuture<Character> implements ApiCallback<CharacterMediaData> {
    
    protected static final Logger LOGGER = LoggerFactory.getLogger(SaveActiveCharacterMediaCallback.class);

    protected final Character character;
    protected final CharacterRepository characterRepository;

    public SaveActiveCharacterMediaCallback(final Character character,
                                            final CharacterRepository characterRepository){
        this.character = character;
        this.characterRepository = characterRepository;
        }


    @Override
    public void onFailure(final ApiException e, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FAIL SaveActiveCharacterMediaCallback : {} - {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode, e.getMessage());
        super.complete(null);
    }

    @Override
    public void onSuccess(CharacterMediaData result, int statusCode, Map<String, List<String>> responseHeaders) {
        LOGGER.info("SUCESS SaveActiveCharacterMediaCallback : {} - {} - {}", this.character.getName(), this.character.getRealm().getSlug(), statusCode);

        this.character.setMediaAvatarURL(result.getAvatarUrl());

        this.characterRepository.save(this.character);

        super.complete(this.character);
        
    }

    @Override
    public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
        // TODO Auto-generated method stub
        
    }
    
}
