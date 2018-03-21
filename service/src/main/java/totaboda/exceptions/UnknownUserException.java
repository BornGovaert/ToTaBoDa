package totaboda.exceptions;

import totaboda.users.LoggedInUser;

public class UnknownUserException extends LibraryException {

    public UnknownUserException(String message) {
        super(message);
    }
}
