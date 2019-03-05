package ru.nemtsov.servlet;

import ru.nemtsov.entity.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "catalog", urlPatterns = "catalog")
public class Catalog extends HttpServlet {

    ProductRepository repository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", repository.getAll());
        getServletContext().getRequestDispatcher("/WEB-INF/views/Catalog.jsp").forward(req, resp);
    }

}
