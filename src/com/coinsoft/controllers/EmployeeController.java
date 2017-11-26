package com.coinsoft.controllers;

import com.coinsoft.models.CmService;
import com.coinsoft.models.Employe;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "EmployeeController", urlPatterns = "/employee")

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

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        String action = request.getParameter("action");

        if(method.equals("GET")) {
            //Index Action
            if(action.equals("index")) {
                List<Employe> employees = service.findAllEmployees();
                request.setAttribute("employee", employees);
                url = "listEmploye.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Employe employe = service.findEmployeById(id);
                request.setAttribute("employee",employe);
                url = "showEmployee.jsp";
            }
            if(action.equals("new")) {
                url = "newCustomer.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
               Employe employe = service.findEmployeById(id);
                request.setAttribute("employee", employe);
                url = "editEmployee.jsp";
            }

        }


        if(method.equals("POST")) {

            if(action.equals("create")) {

                Integer id = 0;
                String code = request.getParameter("code");
                String dni = request.getParameter("dni");
                String name = request.getParameter("name");
                String lastName = request.getParameter("lastName");
                Integer age = Integer.parseInt(request.getParameter("age"));
                String mail = request.getParameter("mail");
                String status="1";
                String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");


                Employe employe = service.createEmploye(id,code,dni,name,lastName,age,mail,status,startDate,endDate);

                List<Employe> employes = service.findAllEmployees();
                request.setAttribute("employee", employes);
                url = "listEmploye.jsp";
            }

            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));;
                String code = request.getParameter("code");
                String dni = request.getParameter("dni");
                String name = request.getParameter("name");
                String lastName = request.getParameter("lastName");
                Integer age = Integer.parseInt(request.getParameter("age"));
                String mail = request.getParameter("mail");
                String starDate = request.getParameter("starDate");
                String endDate = request.getParameter("endDate");
                String status="1";
                boolean isUpdated = service.updateCustomer(id, code,dni,name,lastName,age,mail,status);
                List<Employe> employes = service.findAllEmployees();
                request.setAttribute("employee", employes);
                url = "listEmploye.jsp";


            }

            /*
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                //boolean isUpdated = service.updateEmployee(id, name);
                List<Employe> employes = service.findAllEmployes();
                request.setAttribute("employe", employes);
                url = "listEmploye.jsp";
            }*/
        }
        request.getRequestDispatcher(url).forward(request, response);
    }


}
