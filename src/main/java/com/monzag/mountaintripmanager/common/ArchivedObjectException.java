package com.monzag.mountaintripmanager.common;

public class ArchivedObjectException extends ObjectNotExistException {

    public ArchivedObjectException() {
        super("Object with the given id is archived");
    }
}
