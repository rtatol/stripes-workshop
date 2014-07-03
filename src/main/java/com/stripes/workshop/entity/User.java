package com.stripes.workshop.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author raf
 */
@Entity
@Table(name = "auser")
@NamedQueries({
    @NamedQuery(name = "User.findLiving", query = "SELECT u FROM User u WHERE NOT u.dead")
})
public class User extends AbstractEntity {

    private String name;
    private boolean dead;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "User{ id=" + getId() + ", name=" + name + ", dead=" + dead + '}';
    }

}
