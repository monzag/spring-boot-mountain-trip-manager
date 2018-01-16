package com.monzag.mountaintripmanager.trip;

public class TripNotExistException extends Exception {

    public TripNotExistException() {
        super("Trip with the given id not exist");
    }
}
