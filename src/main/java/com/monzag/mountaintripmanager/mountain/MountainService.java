package com.monzag.mountaintripmanager.mountain;

import org.springframework.stereotype.Service;

@Service
public class MountainService {

    private MountainRepository mountainRepository;

    public MountainService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    public Mountain getMountain(Integer id) throws MountainNotExistException {
        Mountain mountain = mountainRepository.findOne(id);
        if (mountain == null) {
            throw new MountainNotExistException();
        }

        return mountain;
    }

    public Iterable<Mountain> getAll() {
        return mountainRepository.findAll();
    }

    public Mountain createMountain(Mountain mountain) {
        mountainRepository.save(mountain);
        return mountain;
    }
}
