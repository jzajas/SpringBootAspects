// possible change in logic is to change return types of some methods from void to boolean,
// so that LoggerAspect logs the return value of true or false instead of null

package com.jzajas.Aspects.Services;

import com.jzajas.Aspects.Aspects.LogExecutionTime;
import com.jzajas.Aspects.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private List<User> userList;


    public UserService(List<User> userList) {
        this.userList = userList;
    }

    @LogExecutionTime
    public void createUser(String name, String password) {
        User user = new User(name, password);
        userList.add(user);
    }

    @LogExecutionTime
    public void addUser(User user) {
        userList.add(user);
    }

    @LogExecutionTime
    public Optional<User> getUserByID(UUID id) {
        Optional<User> user = userList.stream()
                .filter(u -> u.getID().equals(id))
                .findFirst();
        return user;
    }

    @LogExecutionTime
    public Optional<User> getUserByName(String name) {
        Optional<User> user = userList.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst();
        return user;
    }

    @LogExecutionTime
    public UUID getIDForName(String name) {
        Optional<User> user = userList.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst();
        return user.map(User::getID).orElse(null);
    }

    @LogExecutionTime
    public List<User> getAllUsersWithName(String name) {
        List<User> users = userList.stream()
                .filter(u -> u.getName().equals(name))
                .toList();
        return users;
    }

    @LogExecutionTime
    public int getUserCount() {
        return userList.size();
    }

    @LogExecutionTime
    public void deleteUserById(UUID id) {
        userList.removeIf(u -> u.getID().equals(id));
    }
}
