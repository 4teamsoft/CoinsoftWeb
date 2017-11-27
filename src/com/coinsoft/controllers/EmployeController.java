package com.coinsoft.controllers;

import com.coinsoft.models.CmService;
import com.coinsoft.models.Employe;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@javax.servlet.annotation.WebServlet(name = "EmployeController", urlPatterns = "/employees")

public class EmployeController extends javax.servlet.http.HttpServlet {

    CmService service;
    String url;

    public EmployeController() {
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
            if(action.equals("list")) {
                List<Employe> employees = service.findAllEmployees();
                request.setAttribute("employees", employees);
                url = "listEmployees.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Employe employe = service.findEmployeById(id);
                request.setAttribute("employe",employe);
                url = "showEmploye.jsp";
            }
            if(action.equals("new")) {
                url = "newEmploye.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Employe employe = service.findEmployeById(id);
                request.setAttribute("employe", employe);
                url = "editEmploye.jsp";
            }
            if(action.equals("erase")) {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean isErased = service.eraseEmploye(id);
                List<Employe> employees = service.findAllEmployees();
                request.setAttribute("employees", employees);
                url = "listEmployees.jsp";

            }


        }

        if(method.equals("POST")) {
            // Create Action
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


                if(startDate.length()<2)startDate=null;
                else startDate="'"+startDate+"'";

                if(endDate.length()<2)endDate=null;
                else endDate="'"+endDate+"'";

                Employe employe = service.createEmploye( id,code,dni,name,lastName,age,mail,status,startDate,endDate);

                List<Employe> employees = service.findAllEmployees();
                request.setAttribute("employees", employees);
                url = "listEmployees.jsp";
            }


                if(action.equals("update")) {
                    int id = Integer.parseInt(request.getParameter("id"));;
                    String code = request.getParameter("code");
                    String dni = request.getParameter("dni");
                    String name = request.getParameter("name");
                    String lastName = request.getParameter("lastName");
                    Integer age = Integer.parseInt(request.getParameter("age"));
                    String mail = request.getParameter("mail");
                    String status="1";
                    String startDate = request.getParameter("startDate");
                    String endDate = request.getParameter("endDate");

                    if(startDate.length()<2)startDate=null;
                    else startDate="'"+startDate+"'";

                    if(endDate.length()<2)endDate=null;
                    else endDate="'"+endDate+"'";

                boolean isUpdated = service.updateEmploye(id, code,dni,name,lastName,age,mail,status,startDate,endDate);
                List<Employe> employees = service.findAllEmployees();
                request.setAttribute("employees", employees);
                url = "listEmployees.jsp";


            }
        }


        request.getRequestDispatcher(url).forward(request, response);
    }

}
