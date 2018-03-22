package be.totaboda.api.config;

import be.totaboda.service.exceptions.LibraryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import be.totaboda.service.UserService;
import be.totaboda.service.exceptions.UnknownResourceException;
import be.totaboda.service.exceptions.UnknownUserException;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice(basePackages = {"be/totaboda"})
public class GlobalAdviceController {
    private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @ExceptionHandler(UnknownResourceException.class)
    public ResponseEntity<String> returnStatusForUnknownIdException(final UnknownResourceException exception) {
        LOGGER.log(Level.SEVERE,"ERROR: " + exception.getMessage());
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnknownUserException.class)
    public ResponseEntity<String> returnSatusForUnknownUserException(final UnknownUserException exception)
    {
        LOGGER.log(Level.SEVERE,"ERROR: " + exception.getMessage());
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LibraryException.class)
    public ResponseEntity<String> returnSatusForLibraryException(final UnknownUserException exception)
    {
        LOGGER.log(Level.SEVERE,"ERROR: " + exception.getMessage());
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }
}
