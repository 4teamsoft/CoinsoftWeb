package com.coinsoft.controllers;

import  com.coinsoft.models.CmService;
import com.coinsoft.models.Employe;
import com.coinsoft.models.EmployeesEntity;
import com.coinsoft.models.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;


@javax.servlet.annotation.WebServlet(name = "UserController", urlPatterns = "/users")
public class UserController extends javax.servlet.http.HttpServlet {
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

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (method.equals("GET")) {

            if (action.equals("access")) {
                url = "accessUser.jsp";
            }

            if (action.equals("index")) {
                url = "dashboard.jsp";
            }

            /*if (action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                User user = service.findUserById(id);
                request.setAttribute("users", user);
                url = "showUser.jsp";
            }
            if (action.equals("new")) {
                url = "newUser.jsp";
            }
            if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                User user = service.findUserById(id);
                request.setAttribute("user", user);
                url = "editUser.jsp";
            }*/
        }
        if (method.equals("POST")) {

            if (action.equals("index")) {


                String user = request.getParameter("user");
                String pwd = request.getParameter("pwd");


                User users = service.findUserWithLogin(user, pwd);

                if(users != null){

                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(30*60);
                    session.setAttribute("user", users.getUser());
                    session.setAttribute("type", users.getType());
                    session.setAttribute("employeId", users.getEmployeId());

                    url = "dashboard.jsp";
                }



                /*Employe employe = service.findEmployeById(users.getEmploye().getId());

                request.setAttribute("employe",employe);

                request.setAttribute("countUser", countUser);
                request.setAttribute("countCustomers", countCustomers);*/
/*
                if (countUser != 0) {
                    url = "dashboardForEmployegg.jsp";

                } else {
                    url = "index.jsp";
                }

                if (user.equals("admin") && pwd.equals("admin")) {
                    url = "dashboard.jsp";
                }



*/

            /*if (action.equals("create")) {
                String name = request.getParameter("name");
                User user = service.createUser(name);
                List<User> users = service.findAllRegions();
                request.setAttribute("users", users);
                url = "listUser.jsp";
            }
            if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateUser(id, name);
                List<User> users = service.findAllRegions();
                request.setAttribute("users", users);
                url = "listUsers.jsp";
            }*/
            }
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}