package com.coinsoft.controllers;

import  com.coinsoft.models.CmService;
import com.coinsoft.models.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@javax.servlet.annotation.WebServlet(name = "CustomerController", urlPatterns = "/customers")

public class CustomerController extends javax.servlet.http.HttpServlet {

    CmService service;
    String url;

    public CustomerController() {
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
                List<Customer> customers = service.findAllCustomers();
                  request.setAttribute("customers", customers);
                url = "listCustomers.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = service.findCustomerById(id);
                   request.setAttribute("customer",customer);
                url = "showCustomer.jsp";
            }
            if(action.equals("new")) {
                url = "newCustomer.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = service.findCustomerById(id);
                request.setAttribute("customer", customer);
                url = "editCustomer.jsp";
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

                Customer customer = service.createCustomer( id,code,dni,name,lastName,age,mail,status);

                List<Customer> customers = service.findAllCustomers();
                request.setAttribute("customers", customers);
                url = "listCustomer.jsp";
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
                boolean isUpdated = service.updateCustomer(id, code,dni,name,lastName,age,mail,status);
                List<Customer> customers = service.findAllCustomers();
                request.setAttribute("customers", customers);
                url = "listCustomers.jsp";


            }
        }


        /*

        if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateRegion(id, name);
                List<Region> regions = service.findAllRegions();
                request.setAttribute("regions", regions);
                url = "listRegions.jsp";
            }
         */


        request.getRequestDispatcher(url).forward(request, response);
    }

//




}
