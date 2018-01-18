package com.monzag.mountaintripmanager.trip;

import com.monzag.mountaintripmanager.common.ArchivedObjectException;
import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import org.springframework.stereotype.Service;

@Service
public class TripArchivedService extends TripService {

    public TripArchivedService(TripRepository tripRepository) {
        super(tripRepository);
    }

    @Override
    public void delete(Integer id) throws ObjectNotExistException {
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
    public Trip get(Integer id) throws ObjectNotExistException {
        Trip trip = tripRepository.findOne(id);
        if (trip == null) {
            throw new ObjectNotExistException();
        } else {
            trip = tripRepository.findByIdAndArchived(id, false);
            if (trip == null) {
                throw new ArchivedObjectException();
            }
        }
        return trip;
    }
}
