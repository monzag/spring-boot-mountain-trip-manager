package com.monzag.mountaintripmanager.common;

public interface ResourceService<T> {

    T get(Integer id) throws ObjectNotExistException;

    Iterable<T> getAll();

    T create(T object);

    void delete(Integer id);

}
