package ru.innopolis.Servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ru.innopolis.Servlet.LoginServlet.accountService;

/**
 * Add user servlet
 */
public class AddUserServlet extends HttpServlet{

    public AddUserServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //req.getRequestDispatcher("add/adduser.html").forward(req, resp);

        System.out.println("GetAdduser");
        String user = (String) req.getSession().getAttribute("user");

        if (user != null) {
            req.getRequestDispatcher("/index.html").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/form/adduser.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Если пользователь уже залогинен
        if (session.getAttribute("main") != null) {
            // Отдыхать
            resp.sendRedirect("/home.html");
        } else {
            String username  = req.getParameter("username");
            String password  = req.getParameter("password");
            String password2 = req.getParameter("password2");

            if ((username != null) && (password != null) && (password2 != null)) {

                if (accountService.addUser(username, password)) {
                    req.getSession().setAttribute("userName", username);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginsuccess.jsp");
                    rd.include(req, resp);
                } else {
                    resp.sendRedirect("/login?UserNotRegisteredNotAdded");
                }
            } else {
                resp.sendRedirect("/login?RegFailWrongNullUserNameOrPassword");
            }
        }


    }
}
