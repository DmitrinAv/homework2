package ru.innopolis.Servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter for "/*" in web.xml
 */
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest  request  = (HttpServletRequest)  servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession         session  = request.getSession();

        String uri = request.getRequestURI();

        // Если нет сессии, то ходить далльше (кроме HTML, login, adduser) - нельзя!
        if (session.getAttribute("main") == null && !( uri.endsWith("html")    ||
                                                    uri.endsWith("css")        ||
                                                    uri.endsWith("/adduser/")  ||
                                                    uri.endsWith("adduser")    ||
                                                    uri.endsWith("/login/")    ||
                                                    uri.endsWith("login") )){
            // Неавторизованный доступ
            response.sendRedirect("/login.html");
        } else {
            // Проходите дальше
            filterChain.doFilter(request, response);
        }
    }
}
