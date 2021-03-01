package com.benchelbikh.architecture.buisness;

import com.benchelbikh.architecture.dao.MemoryUserDao;
import com.benchelbikh.architecture.dao.UserDao;
import com.benchelbikh.architecture.models.User;

import java.util.List;

public class DefaultService implements Services{

    UserDao dao;

    public DefaultService() {
        dao = new MemoryUserDao();
    }

    @Override
    public User addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return dao.deleteUser(id);
    }

    @Override
    public User getUser(int id) {
        return dao.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return dao.getUsers();
    }
}
