package totaboda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import totaboda.UserService;
import totaboda.exceptions.UnknownResourceException;
import totaboda.exceptions.UnknownUserException;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice(basePackages = {"totaboda"})
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
}
