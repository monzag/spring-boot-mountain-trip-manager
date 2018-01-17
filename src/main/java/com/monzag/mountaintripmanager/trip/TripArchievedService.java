package com.monzag.mountaintripmanager.trip;

import org.springframework.stereotype.Service;

@Service
public class TripArchievedService extends TripService {

    public TripArchievedService(TripRepository tripRepository) {
        super(tripRepository);
    }

    @Override
    public void delete(Integer id) {
        Trip trip = get(id);
        trip.setArchived(true);
        tripRepository.save(trip);
    }

    @Override
    public Iterable<Trip> getAll() {
        return tripRepository.findByArchived(false);
    }

    @Override
    public Trip get(Integer id) {
        return tripRepository.findByIdAndArchived(id, false);
    }
}
