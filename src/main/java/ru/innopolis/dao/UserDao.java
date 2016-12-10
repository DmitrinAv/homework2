package ru.innopolis.dao;

import ru.innopolis.model.User;
import ru.innopolis.service.DBService;

import java.util.List;

/**
 * Dao для модели User
 */
public interface UserDao {

    public void setDbService(DBService dbService);

    public User createUser(String username, String password);

    public User getUserById(Integer userId);

    public List getAllUsers();

    public void removeUserById(Integer userId);

    public void updateUser(Integer userId, String username);

}
