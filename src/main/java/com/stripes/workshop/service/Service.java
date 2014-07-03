package com.stripes.workshop.service;

import com.stripes.workshop.dao.Dao;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author raf
 * @param <T>
 */
public abstract class Service<T> implements IService<T> {

    protected Logger logger;

    @Inject
    protected Dao dao;

    @PostConstruct
    protected void initializing() {
        logger = Logger.getLogger(getClass().getSimpleName());
    }

    @Override
    public void commit() {
        dao.commit();
    }

}
