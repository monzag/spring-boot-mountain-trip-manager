package com.monzag.mountaintripmanager.trip;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {

    Iterable<Trip> findByArchived(Boolean archived);

    Trip findByIdAndArchived(Integer id, Boolean archived);

}
