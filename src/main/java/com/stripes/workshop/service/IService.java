package com.stripes.workshop.service;

import java.util.List;

/**
 *
 * @author raf
 * @param <T>
 */
public interface IService<T> {

    public List<T> getAll();

    public T get(String id);

    public void create(T object);

    public T update(T object);

    public void delete(T object);

    public void commit();

}
