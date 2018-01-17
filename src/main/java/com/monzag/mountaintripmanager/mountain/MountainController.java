package com.monzag.mountaintripmanager.mountain;

import com.monzag.mountaintripmanager.common.ObjectNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mountains")
public class MountainController {

    private MountainService mountainService;

    public MountainController(MountainService mountainService) {
        this.mountainService = mountainService;
    }

    @GetMapping(path = "")
    public Iterable<Mountain> index() {
        return mountainService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Mountain get(@PathVariable Integer id) throws ObjectNotExistException {
        return mountainService.get(id);
    }

    @PostMapping(path = "")
    public Mountain create(@RequestBody Mountain mountain) {
        return mountainService.create(mountain);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotExistException.class)
    public String handleException(ObjectNotExistException e) {
        return e.getMessage();
    }
}
