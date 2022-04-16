package fr.wowcompanion.server.exception;

public class BlizzardAPIException extends FunctionalException {

    public BlizzardAPIException(final Exception exception) {
        super(exception);
    }
    
}