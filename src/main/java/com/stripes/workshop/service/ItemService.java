package com.stripes.workshop.service;

import com.stripes.workshop.entity.Item;
import java.util.List;

/**
 *
 * @author raf
 */
public class ItemService extends Service<Item> {

    @Override
    public List<Item> getAll() {
        return dao.getAll(Item.class);
    }

    @Override
    public Item get(String id) {
        return dao.get(Item.class, id);
    }

    @Override
    public void create(Item item) {
        dao.create(item);
    }

    @Override
    public Item update(Item item) {
        return dao.update(item);
    }

    @Override
    public void delete(Item item) {
        dao.delete(get(item.getId()));
    }

}
