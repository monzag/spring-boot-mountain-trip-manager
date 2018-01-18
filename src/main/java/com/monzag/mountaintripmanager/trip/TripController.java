package com.monzag.mountaintripmanager.trip;

import com.monzag.mountaintripmanager.common.AppLogger;
import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import com.monzag.mountaintripmanager.common.ResourceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/trips")
public class TripController {

    private ResourceService<Trip> tripService;
    private AppLogger logger;

    public TripController(@Qualifier("tripArchivedService") ResourceService<Trip> tripService, AppLogger logger) {
        this.tripService = tripService;
        this.logger = logger;
    }

    @GetMapping(path = "")
    public Iterable<Trip> index() {
        Iterable<Trip> trips = tripService.getAll();
        logger.debug("Successful getting all objects");
        return trips;
    }

    @GetMapping(path = "/{id}")
    public Trip get(@PathVariable Integer id) throws ObjectNotExistException {
        Trip trip = tripService.get(id);
        logger.debug("Successful getting object by id");
        return trip;
    }

    @PostMapping(path = "")
    public Trip create(@RequestBody Trip trip) {
        tripService.create(trip);
        logger.debug("Successful creating new object");
        return trip;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        tripService.delete(id);
        logger.debug("Succesfull deleting object by id");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotExistException.class)
    public String handleException(ObjectNotExistException e) {
        logger.error("User error: object with provide id not exist or is archived");
        return e.getMessage();
    }
}
