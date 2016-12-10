package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *  Контроллер для веб-перемещений по сайту
 */
@Controller
public class SiteNavigationController {

    @Autowired
    private ModelAndView model;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView helloPage() {
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginPage() {
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/adduser**")
    public ModelAndView adduserPage() {
        model.setViewName("adduser");
        return model;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");
        return model;
    }
}
