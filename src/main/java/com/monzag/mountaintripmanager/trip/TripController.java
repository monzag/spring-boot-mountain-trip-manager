package com.monzag.mountaintripmanager.trip;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/trips")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(path = "")
    public Iterable<Trip> index() {
        return tripService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Trip get(@PathVariable Integer id) throws TripNotExistException {
        return tripService.getTrip(id);
    }

    @PostMapping(path = "")
    public Trip create(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        tripService.deleteTrip(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TripNotExistException.class)
    public String handleException(TripNotExistException e) {
        return e.getMessage();
    }
}
