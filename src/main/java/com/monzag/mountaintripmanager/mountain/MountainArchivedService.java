package com.monzag.mountaintripmanager.mountain;

import org.springframework.stereotype.Service;

@Service
public class MountainArchivedService extends MountainService {

    public MountainArchivedService(MountainRepository mountainRepository) {
        super(mountainRepository);
    }

    
}
