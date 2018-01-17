package com.monzag.mountaintripmanager.mountain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MountainRepository extends CrudRepository<Mountain, Integer> {

    Iterable<Mountain> findByArchived(Boolean archieved);

    Mountain findByIdAndArchived(Integer id, Boolean archieved);
}
