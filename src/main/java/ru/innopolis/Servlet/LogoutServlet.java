package ru.innopolis.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logout servlet
 */
public class LogoutServlet extends HttpServlet {

    public LogoutServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object mainAttribute = session.getAttribute("main");

        if (mainAttribute != null) {
            session.setAttribute("main", null);
            resp.sendRedirect("login.html");
        } else {
            resp.sendRedirect("login.html");
        }
/*        res.setStatus(res.SC_UNAUTHORIZED);
        res.setHeader("WWW-Authenticate","Basic realm=\"testarea\"");*/
    }
}
