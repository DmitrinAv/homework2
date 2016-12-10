package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.model.User;
import ru.innopolis.service.UserServiceImpl;

import java.util.List;

/**
 * User Controller
 *
 * Контроль всех действий, связанных с пользователем
 */

@Controller
public class UserPagesController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelAndView model;

    /**
     * Формирование списка всех User
     * @return открывает страницу со списком User-ов
     */
    @RequestMapping(value = "/listUsers", method = RequestMethod.POST)
    public String ListUsers(Model model) {

        List<User> users = userService.listAllUsers();
        model.addAttribute("users", users);

        return "list/allUsers";
    }

    /**
     * Добавление нового пользователя User
     *
     * @param username Имя
     * @param password password
     * @param password2 подтверждение password
     * @return отправляет на страницу подтверждения успешного добавления нового User
     */
    @RequestMapping(value = "/addUser")
    public ModelAndView addUserPage(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam("password2") String password2) {

        model = userService.createUser(model, username, password, password2);

        return model;
    }

    /**
     * Открытие формы для редактирования текущего User (залогиненного)
     * на которой вводятся новые значения полей профиля User
     *
     * @return отправка на страницу обработки добавления
     */
    @RequestMapping(value = "/edituser")
    public ModelAndView addUserPage() {

        model.setViewName("editUserForm");

        return model;
    }

    /**
     *  Обработка реквизитов в форме редактирования пользователя.
     *  Сохранение изменений
     *
     * @param userid id текущего пользователя
     * @param username username пользователя
     * @return отправляет на страницу с сообщением об успешном редактировании
     */
    @RequestMapping(value = "/editUser")
    public ModelAndView addUserPage(@RequestParam("userid") String userid,
                                    @RequestParam("username") String username) {

        model = userService.updateUser(model, Integer.parseInt(userid), username);

        return model;
    }


}
