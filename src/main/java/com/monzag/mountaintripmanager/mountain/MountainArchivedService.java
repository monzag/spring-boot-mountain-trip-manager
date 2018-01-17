package com.monzag.mountaintripmanager.mountain;

import org.springframework.stereotype.Service;

@Service
public class MountainArchivedService extends MountainService {

    public MountainArchivedService(MountainRepository mountainRepository) {
        super(mountainRepository);
    }

    @Override
    public void delete(Integer id) {
        Mountain mountain = get(id);
        mountain.setArchived(true);
        mountainRepository.save(mountain);
    }

    @Override
    public Iterable<Mountain> getAll() {
        return mountainRepository.findByArchived(false);
    }

    @Override
    public Mountain get(Integer id) {
        return mountainRepository.findByIdAndArchived(id, false);
    }
}
