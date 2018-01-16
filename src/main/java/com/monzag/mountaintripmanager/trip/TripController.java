package com.monzag.mountaintripmanager.trip;

import org.springframework.web.bind.annotation.GetMapping;
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
}
