package com.benchelbikh.architecture.buisness;

import com.benchelbikh.architecture.models.User;

import java.util.List;

public interface Services {
    public User addUser(User user);
    public User updateUser(User user);
    public boolean deleteUser(int id);
    public User getUser(int id);
    public List<User> getUsers();
}
