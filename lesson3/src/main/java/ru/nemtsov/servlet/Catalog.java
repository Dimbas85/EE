package ru.nemtsov.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "catalog", urlPatterns = "catalog")
public class Catalog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Menu</h1>");
        resp.getWriter().println("<a href=\"main\">Main</a>");
        resp.getWriter().println("Catalog");
        resp.getWriter().println("<a href=\"cart\">Cart</a>");
        resp.getWriter().println("<h1>Catalog<h1>");
    }
}
