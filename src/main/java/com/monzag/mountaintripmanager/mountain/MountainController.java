package com.monzag.mountaintripmanager.mountain;

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

    @GetMapping(path = "{id}")
    public Mountain get(@PathVariable Integer id) {
        return mountainService.getMountain(id);
    }

    @PostMapping(path = "")
    public Mountain create(@RequestBody Mountain mountain) {
        return mountainService.createMountain(mountain);
    }
}
