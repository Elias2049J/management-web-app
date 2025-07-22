package org.elias.clase1jsp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.elias.clase1jsp.entity.User;
import org.elias.clase1jsp.service.LoginService;
import org.elias.clase1jsp.service.SecurityService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/login")
@Setter
@Getter
public class LoginServlet extends HttpServlet {
    private LoginService loginService;
    private SecurityService securityService;
    private Logger log;
    private List<User> users;

    @Override
    public void init() throws ServletException {
        super.init();
        this.log = Logger.getLogger(LoginServlet.class.getName());

        if (getServletContext().getAttribute("users") == null) {
            getServletContext().setAttribute("users", new ArrayList<User>());
        }
        this.users = (List<User>) getServletContext().getAttribute("users");

        this.securityService = new SecurityService();
        this.loginService = new LoginService(users, securityService);

        log.info("LoginServlet initialized with " + users.size() + " users");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("txtName");
        String pass = request.getParameter("txtPass");

        log.info("Processing login request for user: " + name);

        boolean result = loginService.handleLogin(name, pass);
        if (result) {
            log.info("Login successful for user: " + name);
            response.sendRedirect("dashboard.jsp");
        } else {
            log.info("Login failed for user: " + name);
            request.setAttribute("result", false);
            response.sendRedirect("login.jsp");
        }
    }
}