package com.monzag.mountaintripmanager.mountain;

public class MountainNotExistException extends Exception {

    public MountainNotExistException() {
        super("Mountain with the given id not exist");
    }
}
