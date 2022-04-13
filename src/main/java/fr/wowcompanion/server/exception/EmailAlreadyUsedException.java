package fr.wowcompanion.server.exception;

public class EmailAlreadyUsedException extends FunctionalException {

    public EmailAlreadyUsedException(final String email) {
        super("The email '" + email + "' are already used");
    }
}