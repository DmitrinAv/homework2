package ru.innopolis.Servlet;

import ru.innopolis.Entity.AccountService;
import ru.innopolis.Entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Login servlet
 */
public class LoginServlet extends HttpServlet {

    protected final static AccountService accountService = new AccountService();

    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.html").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ((username != null) && (password != null)) {

            User user = accountService.getUser(username, password);
            req.getSession().setAttribute("userName", username);

            if (user != null) {
                session.setAttribute("main", user);
                //userToken / ID
                resp.sendRedirect("/loginsuccess.jsp");
                //resp.sendRedirect("/home.html");
                return;
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
                PrintWriter out = resp.getWriter();
                out.println("<font color=red>Either user name or password is wrong.</font>");
                requestDispatcher.include(req, resp);
            }
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either user name or password is Null</font>");
            requestDispatcher.include(req, resp);
        }
    }
}
