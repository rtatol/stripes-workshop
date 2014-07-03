package com.stripes.workshop.service;

import com.stripes.workshop.entity.User;
import java.util.List;

/**
 *
 * @author raf
 */
public class UserService extends Service<User> {

    public List<User> getLivingUsers() {
        return dao.find(User.class, "User.findLiving");
    }

    @Override
    public List<User> getAll() {
        return dao.getAll(User.class);
    }

    @Override
    public User get(String id) {
        return dao.get(User.class, id);
    }

    @Override
    public void create(User user) {
        dao.create(user);
    }

    @Override
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    public void delete(User user) {
        dao.delete(get(user.getId()));
    }
}
