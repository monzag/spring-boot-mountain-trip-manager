package com.monzag.mountaintripmanager.trip;

import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import com.monzag.mountaintripmanager.common.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class TripService implements ResourceService<Trip> {

    public TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public void create(Trip trip) {
        tripRepository.save(trip);
    }

    public Trip get(Integer id) throws ObjectNotExistException {
        Trip trip = tripRepository.findOne(id);
        if (trip == null) {
            throw new ObjectNotExistException();
        }
        return trip;
    }

    public Iterable<Trip> getAll() {
        return tripRepository.findAll();
    }

    public void delete(Integer id) throws ObjectNotExistException {
        tripRepository.delete(id);
    }

}
