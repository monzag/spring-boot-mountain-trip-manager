package com.monzag.mountaintripmanager.mountain;

import com.monzag.mountaintripmanager.common.ArchivedObjectException;
import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import org.springframework.stereotype.Service;

@Service
public class MountainArchivedService extends MountainService {

    public MountainArchivedService(MountainRepository mountainRepository) {
        super(mountainRepository);
    }

    @Override
    public void delete(Integer id) throws ObjectNotExistException {
        Mountain mountain = get(id);
        mountain.setArchived(true);
        mountainRepository.save(mountain);
    }

    @Override
    public Iterable<Mountain> getAll() {
        return mountainRepository.findByArchived(false);
    }

    @Override
    public Mountain get(Integer id) throws ObjectNotExistException {
        Mountain mountain = mountainRepository.findOne(id);
        if (mountain == null) {
            throw new ObjectNotExistException();
        } else {
            mountain = mountainRepository.findByIdAndArchived(id, false);
            if (mountain == null) {
                throw new ArchivedObjectException();
            }
        }
        return mountain;
    }
}
