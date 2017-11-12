package com.coinsoft.controllers;

import com.coinsoft.models.CmService;
import com.coinsoft.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UserController", urlPatterns = "/user")
public class UsersController extends javax.servlet.http.HttpServlet {
    CmService service;
    String url;

    public UserController() {
        super();
        service = new CmService();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");

        if(method.equals("GET")) {
            // Index Action
            if(action.equals("index")) {
                List<User> users = service.findAllRegions();
                request.setAttribute("users", users);
                url = "listUser.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                User region = service.findRegionById(id);
                request.setAttribute("user", user);
                url = "showUser.jsp";
            }
            if(action.equals("new")) {
                url = "newUser.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                User user = service.findRegionById(id);
                request.setAttribute("user", user);
                url = "editUser.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
                User user = service.createUser(name);
                List<User> users = service.findAllRegions();
                request.setAttribute("users", users);
                url = "listUser.jsp";
            }
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateUser(id, name);
                List<User> users = service.findAllRegions();
                request.setAttribute("users", users);
                url = "listUsers.jsp";
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}