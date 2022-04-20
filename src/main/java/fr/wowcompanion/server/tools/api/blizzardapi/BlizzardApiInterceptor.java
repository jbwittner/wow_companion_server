package fr.wowcompanion.server.tools.api.blizzardapi;

import okhttp3.Interceptor;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlizzardApiInterceptor implements Interceptor {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BlizzardApiInterceptor.class);
    public static final int LIMIT_CALL = 100;

    @Override
    public Response intercept(final Chain chain) throws IOException {

        final long start = System.currentTimeMillis();

        boolean doContinue = false;

        Response response;

        LOGGER.info("STARTING Api call : '{}'",chain.request().url().uri());

        int count = 0;

        do {
            count++;
            final Request request = chain.request();
            response = chain.proceed(request);
            doContinue = response.code() == 429;
            
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("CALL : '{}' - CODE : {}",chain.request().url().uri(), response.code());
            }

            if(count >= LIMIT_CALL){
                doContinue = false;
                LOGGER.warn("ENDING api call : '{}' limit call",chain.request().url().uri());
            }

            try {
                Thread.sleep(10L);
            } catch (final InterruptedException e) {
                LOGGER.error("ERROR Thread", e);
                Thread.currentThread().interrupt();
            }
            
        } while (doContinue);

        final long executionTime = System.currentTimeMillis() - start;
        LOGGER.info("Ending api call : '{}' in {} ms",chain.request().url().uri(), executionTime);

        return response;
    }
    
}
