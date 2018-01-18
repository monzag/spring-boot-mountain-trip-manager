package com.monzag.mountaintripmanager.mountain;

import com.monzag.mountaintripmanager.common.AppLogger;
import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import com.monzag.mountaintripmanager.common.ResourceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mountains")
public class MountainController {

    private ResourceService<Mountain> mountainService;
    private AppLogger logger;

    public MountainController(@Qualifier("mountainArchivedService") ResourceService<Mountain> mountainService, AppLogger logger) {
        this.mountainService = mountainService;
        this.logger = logger;
    }

    @GetMapping(path = "")
    public Iterable<Mountain> index() {
        Iterable<Mountain> mountains = mountainService.getAll();
        logger.debug("Successful getting all mountains");
        return mountains;
    }

    @GetMapping(path = "/{id}")
    public Mountain get(@PathVariable Integer id) throws ObjectNotExistException {
        logger.info("Get mountain by id");
        Mountain mountain = mountainService.get(id);
        logger.debug("Successful getting mountain by id");
        return mountain;
    }

    @PostMapping(path = "")
    public Mountain create(@RequestBody Mountain mountain) {
        mountainService.create(mountain);
        return mountain;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotExistException.class)
    public String handleException(ObjectNotExistException e) {
        return e.getMessage();
    }
}
