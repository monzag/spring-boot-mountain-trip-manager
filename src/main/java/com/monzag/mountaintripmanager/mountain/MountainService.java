package com.monzag.mountaintripmanager.mountain;

import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import com.monzag.mountaintripmanager.common.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class MountainService implements ResourceService<Mountain> {

    private MountainRepository mountainRepository;

    public MountainService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    public Mountain get(Integer id) throws ObjectNotExistException {
        Mountain mountain = mountainRepository.findOne(id);
        if (mountain == null) {
            throw new ObjectNotExistException();
        }

        return mountain;
    }

    public Iterable<Mountain> getAll() {
        return mountainRepository.findAll();
    }

    public Mountain create(Mountain mountain) {
        mountainRepository.save(mountain);
        return mountain;
    }

    public void delete(Integer id) {
        mountainRepository.delete(id);
    }
}
