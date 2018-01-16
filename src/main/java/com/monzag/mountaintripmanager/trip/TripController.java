package com.monzag.mountaintripmanager.trip;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/trips")
public class TripController {

    @GetMapping(path = "")
    public Iterable<Trip> index() {
        return new ArrayList<>();
    }

    @GetMapping(path = "/{id}")
    public Trip get(@PathVariable Integer id) {
        return new Trip();
    }

    @PostMapping(path = "")
    public Trip create(@RequestBody Trip trip) {
        return trip;
    }
}
