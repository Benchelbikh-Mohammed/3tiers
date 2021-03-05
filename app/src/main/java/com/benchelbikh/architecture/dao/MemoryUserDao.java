package com.benchelbikh.architecture.dao;

import com.benchelbikh.architecture.models.User;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserDao implements UserDao{
    private List<User> users;
    private int max;

    public MemoryUserDao(){
        users=new ArrayList<>();
        users.add(new User(1,"John Doe",
                "jhon.doe@example.com","Jhon1"));
        users.add(new User(2,"Patrick Jane",
                "patrick.jane@example.com","JaneMentalist"));

        max=2;

    }
    @Override
    public User addUser(User user) {
        user.setId(++max);
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        for (User t:users)
            if(t.getId()==user.getId())
            {
                t.setEmail(user.getEmail());
                t.setUsername(user.getUsername());
                t.setName(user.getName());
                return t;
            }
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        for (User t:users)
            if(t.getId()==id)
            {
                users.remove(t);
                return true;
            }
        return false;
    }

    @Override
    public User getUser(int id) {
        for (User t:users)
            if(t.getId()==id)
                return t;
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

}
