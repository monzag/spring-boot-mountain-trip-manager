package com.monzag.mountaintripmanager.mountain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "{id}")
    public Mountain get(@PathVariable Integer id) {
        return mountainService.getMountain(id);
    }
}
