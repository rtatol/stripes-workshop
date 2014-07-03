package com.stripes.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author raf
 */
@Entity
@Table(name = "item")
public class Item extends AbstractEntity {

    private String name;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Item{ id=" + getId() + ", name=" + name + ", price=" + price + ", user=" + user + '}';
    }

}
