package ru.nemtsov.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (filterName = "SecurityFilter", urlPatterns = "/cart")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(false);

        if (session == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/WEB-INF/views/Login.jsp");
        } else {
            String user = (String) session.getAttribute("user");

            httpResponse.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
            httpResponse.getWriter().println("<p>User " + user + " is logged in. <a href=\"logout_serv\">Logout</a></p>");
        }

//        filterChain.doFilter(servletRequest, servletResponse);
        filterChain.doFilter(httpRequest, httpResponse);
    }

}
