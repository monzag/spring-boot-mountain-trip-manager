package com.monzag.mountaintripmanager.mountain;

import org.springframework.stereotype.Service;

@Service
public class MountainService {

    private MountainRepository mountainRepository;

    public MountainService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }
}
