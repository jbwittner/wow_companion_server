package fr.wowcompanion.server.exception;

public class UserNameAlreadyUsedException extends FunctionalException {

    public UserNameAlreadyUsedException(final String userName) {
        super("The user name '" + userName + "' are already used");
    }
}