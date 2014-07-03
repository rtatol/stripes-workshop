package com.stripes.workshop.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.eclipse.persistence.annotations.UuidGenerator;

/**
 *
 * @author raf
 */
@MappedSuperclass
@UuidGenerator(name = "uuid_generator")
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid_generator")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
