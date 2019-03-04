package ru.nemtsov.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "main", urlPatterns = "/main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Menu</h1>");
        resp.getWriter().println("Main");
        resp.getWriter().println("<a href=\"catalog\">Catalog</a>");
        resp.getWriter().println("<a href=\"cart\">Cart</a>");
        resp.getWriter().println("<h1>Main page</h1>");
    }
}
