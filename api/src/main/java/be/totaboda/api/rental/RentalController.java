package be.totaboda.api.rental;

import be.totaboda.service.BookService;
import be.totaboda.service.RentalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(path = "/rentals")
public class RentalController {
    private RentalService rentalService;

    @Inject
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


}
