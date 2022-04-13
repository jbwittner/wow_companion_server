package fr.wowcompanion.server.exception;

public abstract class FunctionalException extends RuntimeException{

    protected FunctionalException(final String message){
        super(message);
    }

    protected FunctionalException(final Exception exception){
        super(exception);
    }

    protected FunctionalException(){
        super();
    }
    
}
