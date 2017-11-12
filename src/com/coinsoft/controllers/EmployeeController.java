package com.coinsoft.controllers;

import  com.coinsoft.models.CmService;
import com.coinsoft.models.Employe;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@javax.servlet.annotation.WebServlet(name = "EmployeeController", urlPatterns = "/employe")

public class EmployeeController extends javax.servlet.http.HttpServlet {

    CmService service;
    String url;

    public EmployeeController() {
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
               // List<Employe> employes = service.findAllEmployee();
               // request.setAttribute("customers", employes);
                url = "listCustomer.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
               // Employe employe = service.findEmployeeById(id);
               // request.setAttribute("auditTrail",employe);
                url = "showCustomer.jsp";
            }
            if(action.equals("new")) {
                url = "newCustomer.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
             //   Employe employe = service.findEmployeeById(id);
              //  request.setAttribute("auditTrail", employe);
                url = "editCustomer.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
              //  Employe employe = service.createCustomer(name);
              //  List<Employe> employes = service.findAllEmployee();
              //  request.setAttribute("auditTrail", employe);
                url = "listCustomer.jsp";
            }
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
              //  boolean isUpdated = service.updateEmployee(id, name);
              //  List<Employe> employes = service.findAllEmployee();
              //  request.setAttribute("auditTrail", employes);
                url = "listCustomer.jsp";
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }













}
