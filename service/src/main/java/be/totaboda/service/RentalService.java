package be.totaboda.service;


import be.totaboda.domain.rental.RentalRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
public class RentalService {

    private RentalRepository rentalRepository;
    private final static Logger LOGGER = Logger.getLogger(BookService.class.getName());

    @Inject
    public RentalService(RentalRepository rentalRepository){
        this.rentalRepository = rentalRepository;
    }


}
