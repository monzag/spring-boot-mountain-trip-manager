package com.monzag.mountaintripmanager.trip;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/trips")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(path = "")
    public Iterable<Trip> index() {
        return new ArrayList<>();
    }

    @GetMapping(path = "/{id}")
    public Trip get(@PathVariable Integer id) {
        return tripService.get(id);
    }

    @PostMapping(path = "")
    public Trip create(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }
}
