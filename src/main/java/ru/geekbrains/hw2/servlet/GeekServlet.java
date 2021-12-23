package ru.geekbrains.hw2.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GeekServlet", urlPatterns = "/geek")
public class GeekServlet extends HttpServlet {
    Logger LOG = LoggerFactory.getLogger(GeekServlet.class);
    private transient GeekServletConfig config;

    public void init(GeekServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("New GET request");
        ApplicationContext context = new AnnotationConfigApplicationContext(GeekServletConfig.class);
        GetController controller = context.getBean("GET", GetController.class);
        controller.setResponse(resp);
        controller.doQuerry(req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("New POST request");
        resp.getWriter().println("<h1>Fuck POST!</h1>");
    }

    public String getServletInfo() {
        return "Training servlet";
    }

    public void destroy() {
        LOG.info("Servlet {} destroyed",getServletInfo());
    }
}
