package ru.innopolis.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Home servlet / Site content
 */
public class HomeServlet extends HttpServlet {

    public HomeServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object mainAtribute = session.getAttribute("main");

        if (mainAtribute != null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("login?noSessionFound");
        }
    }
}
