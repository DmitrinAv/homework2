package ru.innopolis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.dao.UserDaoImpl;
import ru.innopolis.model.User;

import java.util.List;

/**
 * User Service
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * Создает нового пользователя в базе, вызвав соотвествующий метод в Дао
     *
     * @param model
     * @param username
     * @param password
     * @param password2
     * @return ModelAndView
     */
    @Override
    public ModelAndView createUser(ModelAndView model, String username, String password, String password2) {

        //todo Проверить, что пользователь с таким именем не существует

        if ((username != null) && (password != null) && (!"".equals(username)) && (!"".equals(password))) {

            if ((password.equals(password2))) {

                if ((userDao.createUser(username, bCryptPasswordEncoder.encode(password))) != null) {
                    model.addObject("username", username);
                    model.setViewName("loginsuccess");
                    logger.info("UserDao: Пользователь {} успешно добавлен!", username);
                } else {
                    //todo Обработать пользователь не добавлен
                    model.setViewName("adduser");
                    logger.info("UserDao: Пользователь {} не добавлен!", username);
                }
            } else {
                //todo Обработать пользователь не добавлен
                logger.info("UserDao: Пользователь {} не добавлен! Введенные пароли не совпадают!", username);
            }
            return model;
        } else {
            //todo Обработать пользователь не добавлен
            logger.info("UserDao: Логин и пароль не должны быть пустыми!");
        }
        return model;
    }

    /**
     * Выводит список всех пользователей на экран
     *
     * @param model
     * @return ModelAndView
     */
    public List<User> listAllUsers() {
        List<User> users;

        if ((users = userDao.getAllUsers()) != null) {
            return users;
        } else {
            //todo Обработать ошибку пустого списка
            return null;
        }
    }

    @Override
    public ModelAndView updateUser(ModelAndView model, Integer userid, String username) {

        if ( (username != null) && (!"".equals(username))) {
            userDao.updateUser(userid, username);
            model.setViewName("loginsuccess");
        } else {
            //todo отработать ситуацию
            logger.info("EditUser: Логин не должен быть пустым!", username);
        }
        return model;
    }
}
