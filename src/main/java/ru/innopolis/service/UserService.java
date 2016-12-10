package ru.innopolis.service;

import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.model.User;

import java.util.List;

/**
 * User Service Interface
 */
public interface UserService {
    public ModelAndView createUser(ModelAndView model, String username, String password, String password2);

    public List<User> listAllUsers();

    public ModelAndView updateUser(ModelAndView model, Integer userid, String username);
}
