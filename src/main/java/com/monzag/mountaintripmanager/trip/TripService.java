package com.monzag.mountaintripmanager.trip;

import org.springframework.stereotype.Service;

@Service
public class TripService {

    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip get(Integer id) {
        Trip trip = tripRepository.findOne(id);
        if (trip == null) {
            System.out.println("Exception: trip not exist");
        }
        return trip;
    }

    public Trip createTrip(Trip trip) {
        tripRepository.save(trip);
        return trip;
    }
}
