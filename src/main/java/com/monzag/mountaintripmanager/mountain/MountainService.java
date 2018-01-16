package com.monzag.mountaintripmanager.mountain;

import org.springframework.stereotype.Service;

@Service
public class MountainService {

    private MountainRepository mountainRepository;

    public MountainService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    public Mountain getMountain(Integer id) {
        return mountainRepository.findOne(id);
    }

    public Iterable<Mountain> getAll() {
        return mountainRepository.findAll();
    }

    public Mountain create(Mountain mountain) {
        mountainRepository.save(mountain);
        return mountain;
    }
}
