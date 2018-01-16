package com.monzag.mountaintripmanager.trip;

import org.springframework.stereotype.Service;

@Service
public class TripService {

    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip getTrip(Integer id) throws TripNotExistException {
        Trip trip = tripRepository.findOne(id);
        if (trip == null) {
            throw new TripNotExistException();
        }
        return trip;
    }

    public Iterable<Trip> getAll() {
        return tripRepository.findAll();
    }

    public Trip createTrip(Trip trip) {
        tripRepository.save(trip);
        return trip;
    }
}
