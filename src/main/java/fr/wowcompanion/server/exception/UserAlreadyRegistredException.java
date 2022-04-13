package fr.wowcompanion.server.exception;

public class UserAlreadyRegistredException extends FunctionalException {

    public UserAlreadyRegistredException(final String battletag) {
        super("The account with the battletag '" + battletag + "' are already registred");
    }
}
