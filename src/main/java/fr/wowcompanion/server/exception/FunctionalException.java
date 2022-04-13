package fr.wowcompanion.server.exception;

public abstract class FunctionalException extends RuntimeException{

    protected FunctionalException(final String message){
        super(message);
    }

}
