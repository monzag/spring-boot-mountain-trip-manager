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

    public Trip create(Trip trip) {
        tripRepository.save(trip);
        return trip;
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

    public void delete(Integer id) {
        tripRepository.delete(id);
    }


//    public void delete(Integer id) {
//        Trip trip = get(id);
//        trip.setArchived(true);
//    }
//
//    public Iterable<Trip> getAll() {
//        return tripRepository.findByArchived(false);
//    }
//
//    public Trip get(Integer id) {
//        return tripRepository.findByIdAndArchived(id, false);
//    }

}
