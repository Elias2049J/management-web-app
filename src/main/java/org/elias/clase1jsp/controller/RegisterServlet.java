package org.elias.clase1jsp.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.elias.clase1jsp.entity.User;
import org.elias.clase1jsp.service.SecurityService;
import org.elias.clase1jsp.service.UserCrudService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/register")
@Setter
@Getter
public class RegisterServlet extends HttpServlet {
    private UserCrudService userCrudService;
    private SecurityService securityService;
    private LoginServlet loginServlet;
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private List<User> users;

    @Override
    public void init() {
        if (getServletContext().getAttribute("users") == null) {
            getServletContext().setAttribute("users", new ArrayList<User>());
        }
        this.users = (List<User>) getServletContext().getAttribute("users");
        this.securityService = new SecurityService();
        this.userCrudService = new UserCrudService(securityService, users);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("txtName");
        String pass = request.getParameter("txtPass");

        // creating the User object once we have the pass and name of him
        boolean result = userCrudService.create(new User(1, name, pass));
        if (result) response.sendRedirect("dashboard.jsp");
        else {
            request.setAttribute("result", false);
            response.sendRedirect("register.jsp");
        }
    }
}