package com.monzag.mountaintripmanager.trip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
