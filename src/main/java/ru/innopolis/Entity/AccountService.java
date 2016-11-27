package ru.innopolis.Entity;

import ru.innopolis.Connection.ConnectionFactory;

import java.sql.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * (BOX) Accounts container (MAP) / service (SQL)
 */
public class AccountService {

    private Map<String, User> userList = new ConcurrentHashMap<>();

    /**
     * Конструктор. Для тестирования один элемент уже создан
     */
    // Тестирование, пусть 1 элемент уже будет в базе
    public AccountService() {
        userList.put("admin", new User("admin", "admin"));
    }

    /**
     * Поиск в базе по username / password
     * @param userName username
     * @param password password
     * @return возвращает объект класса User
     */
    public User getUser(String userName, String password) {

        try (Connection connection = ConnectionFactory.getSqlConnection()){

            Statement statement = connection.createStatement();
            ResultSet resultQuery = statement.executeQuery(String.format("SELECT * FROM users where username = '%s' and password = '%s'", userName, password));

            if (resultQuery.next()) {
                return new User(resultQuery.getString(1), resultQuery.getString(2));
            }
            return  null;

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL Query", e);
        }

//            while (resultQuery.next()) {
//                System.out.println("Номер в выборке #" + resultQuery.getRow()
//                        + "\t Номер в базе #" + resultQuery.getInt("id")
//                        + "\t" + resultQuery.getString("username"));
//            }

//        if (userList.containsKey(userName)) {
//            User getMe = userList.get(userName);
//            if (getMe.getPassword().equals(password)) {
//                return getMe;
//            }
//        }
//        return null;
    }

    /**
     * Добавляет запись UserName / Password в SQL Базу
     * @param userName
     * @param passWord
     * @return True - при удачном добавлении / False в случае отказа
     */
    public boolean addUser(String userName, String passWord) {

        if (getUser(userName, passWord) == null) {
            try (Connection connection = ConnectionFactory.getSqlConnection()) {

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM users");
                resultSet.next();
                int countRaw = resultSet.getInt(1);
                int count = statement.executeUpdate(String.format("INSERT INTO users (id, username, password) VALUES (%d, '%s', '%s')", (countRaw+1), userName, passWord));

                if (count == 1) return true;

                return false;

            } catch (SQLException e) {
                throw new RuntimeException("Error Adding new user", e);
            }
        } else {
            return false;
        }

//        if (userList.containsKey(userName)) {
//            return false;
//        }
//        userList.put(userName, passWord);
//        return true;
    }

//    public boolean AddSession (String userName, User user) {
//        if (sessionList.containsKey(userName)) {
//            return false;
//        }
//        userList.put(userName, user);
//        return true;
//    }
}
