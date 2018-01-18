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
        logger.debug("Successful getting all trips");
        return trips;
    }

    @GetMapping(path = "/{id}")
    public Trip get(@PathVariable Integer id) throws ObjectNotExistException {
        logger.info("Get trip by id");
        Trip trip = tripService.get(id);
        logger.debug("Successful getting trip by id");
        return trip;
    }

    @PostMapping(path = "")
    public Trip create(@RequestBody Trip trip) {
        tripService.create(trip);
        logger.debug("Successful creating new trip");
        return trip;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) throws ObjectNotExistException {
        logger.info("Delete trip by id");
        tripService.delete(id);
        logger.debug("Successfull deleting trip by id");
    }
}
