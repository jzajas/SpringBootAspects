package com.jzajas.Aspects.Services;

import com.jzajas.Aspects.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> userList;


    public UserService(List<User> userList) {
        this.userList = userList;

    }

    public void createUser(String name, String password) {
        User user = new User(UUID.randomUUID(), name, password);
        userList.add(user);
    }

    public Optional<User> getUserByID(UUID id) {
        Optional<User> user = userList.stream().filter(u -> u.getID().equals(id)).findFirst();

        return user;
    }

    public Optional<User> getUserByName(String name) {
        Optional<User> user = userList.stream().filter(u -> u.getName().equals(name)).findFirst();

        return user;
    }

    public List<User> getAllUsersWithName(String name) {
        List<User> users = userList.stream().filter(u -> u.getName().equals(name)).toList();
        return users;
    }

    public int getUserCount() {
        return userList.size();
    }

    public void deleteUserById(UUID id) {
        userList.removeIf(u -> u.getID().equals(id));
    }
}
