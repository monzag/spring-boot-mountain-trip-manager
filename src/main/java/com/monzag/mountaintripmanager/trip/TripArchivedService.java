package com.monzag.mountaintripmanager.trip;

import org.springframework.stereotype.Service;

@Service
public class TripArchivedService extends TripService {

    public TripArchivedService(TripRepository tripRepository) {
        super(tripRepository);
    }

    @Override
    public void delete(Integer id) {
        Trip trip = get(id);
        trip.setArchived(true);
        trip.getMountain().setArchived(true);
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
