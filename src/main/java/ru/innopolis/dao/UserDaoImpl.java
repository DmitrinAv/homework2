package ru.innopolis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.model.Role;
import ru.innopolis.model.User;
import ru.innopolis.service.DBService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * UserDaoImpl - Реализация модели Дао для модели User
 */
@Repository
public class UserDaoImpl implements UserDao {

    private DBService dbService;

    @Autowired
    public void setDbService(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public User createUser(String username, String password) {

        EntityManager manager = dbService.getEntityManagerFactory().createEntityManager();

        Query query = manager.createQuery("select c from User c where username = :username");
        query.setParameter("username", username);
        User user = null;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            // * NOPE *
        }

        if (user != null) {
            manager.close();
            return user;
            //todo Отработать ситуацию, когда пользователь уже добавлен
        }

        query = manager.createQuery("select c from Role c where username = :username");
        query.setParameter("username", username);
        Role role = null;
        try {
                role = (Role) query.getSingleResult();
        } catch (NoResultException e) {
            // * NOPE *
        }

        if (role != null) {
            //todo Отработать ситуацию, когда пользователь с таким логином уже записан в базе
        }

        user = new User(username);
        manager.merge(user);

        role = new Role(username, password, "ROLE_USER");
        manager.merge(role);


        manager.close();
        return user;

//        String query = "insert into sl_user values(?)";
//
//        manager.createNativeQuery(query)
//                .setParameter(1, username)
//                .executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {

        EntityManager manager = dbService.getEntityManagerFactory().createEntityManager();

        List<User> allUsers = manager.createQuery("select c from User c").getResultList();

//        String SQL = "SELECT * FROM sl_user"; //Запрос, который Вас интересует
//        Query query = manager.createNativeQuery(SQL); //Не требует маппинга
////        query.setParameter("какой-то параметр", 123);
//        List<User> allUsers = query.getResultList();

        manager.close();

        return allUsers;
    }

    @Override
    public User getUserById (Integer user_id) {

        EntityManager manager = dbService.getEntityManagerFactory().createEntityManager();
        User user = manager.find(User.class, user_id);
        manager.close();

        return user;
    }



    @Override
    public void updateUser(Integer userid, String username) {
//        String SQL = "UPDATE sl_user SET user_id = ?, username = ? WHERE user_id = ?";
//        jdbcTemplate.update(SQL, userid, username, userid);
    }

    @Override
    public void removeUserById(Integer userId) {

    }

}
