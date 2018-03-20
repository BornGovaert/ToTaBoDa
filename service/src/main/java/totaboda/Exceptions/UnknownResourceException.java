package totaboda.Exceptions;

public class UnknownResourceException extends LibraryException {

    public UnknownResourceException(String field, String resource) {
        super(String.format("The %s could not be found based on the provided %s.", field, resource));
    }
}
