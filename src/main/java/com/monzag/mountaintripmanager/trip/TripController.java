package com.monzag.mountaintripmanager.trip;

import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import com.monzag.mountaintripmanager.common.ResourceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/trips")
public class TripController {

    private ResourceService<Trip> tripService;

    public TripController(@Qualifier("tripArchivedService") ResourceService<Trip> tripService) {
        this.tripService = tripService;
    }

    @GetMapping(path = "")
    public Iterable<Trip> index() {
        return tripService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Trip get(@PathVariable Integer id) throws ObjectNotExistException {
        return tripService.get(id);
    }

    @PostMapping(path = "")
    public Trip create(@RequestBody Trip trip) {
        return tripService.create(trip);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        tripService.delete(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotExistException.class)
    public String handleException(ObjectNotExistException e) {
        return e.getMessage();
    }
}
