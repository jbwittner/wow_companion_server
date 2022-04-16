package fr.wowcompanion.server.tools.api.blizzardapi.callback;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import fr.jbwittner.blizzardswagger.wowretailapi.ApiCallback;
import fr.jbwittner.blizzardswagger.wowretailapi.ApiException;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CharacterCallback extends CompletableFuture<CharacterData> implements ApiCallback<CharacterData>{

    protected static final Logger LOGGER = LoggerFactory.getLogger(CharacterCallback.class);
    protected String characterName;

    public CharacterCallback(){
        super();
    }

    public CharacterCallback(final String characterName){
        super();
        LOGGER.info("START CharacterCallback : {}", characterName);
        this.characterName = characterName;
    }

    @Override
    public void onFailure(final ApiException e, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FAIL CharacterCallback : {}", characterName);
        super.complete(null);
    }

    @Override
    public void onSuccess(final CharacterData result, final int statusCode, final Map<String, List<String>> responseHeaders) {
        LOGGER.info("FINISHED CharacterCallback : {}", characterName);
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