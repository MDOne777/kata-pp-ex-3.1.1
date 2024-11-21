package org.spring.boot.kata.service;


import org.spring.boot.kata.model.User;
import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User get(int id);
    public void save(User user);
    public void delete(int id);
}
