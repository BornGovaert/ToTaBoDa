package be.totaboda.api.rental;

import be.totaboda.service.BookService;
import be.totaboda.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(path = "/rentals")
public class RentalController {
    private RentalService rentalService;

    @Inject
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RentalDto createRental(@RequestBody RentalDto rental){
        return RentalMapper.rentalToDto(rentalService.createRental(rental.memberId, rental.bookIsbn));
    }

    @DeleteMapping(path ="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnBook(@PathVariable int id) {
        rentalService.returnBook(id);
    }
}
