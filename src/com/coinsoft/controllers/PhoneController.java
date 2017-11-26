package com.coinsoft.controllers;


import com.coinsoft.models.CmService;
import com.coinsoft.models.Customer;
import com.coinsoft.models.Phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "PhoneController", urlPatterns = "/phone")
public class PhoneController extends javax.servlet.http.HttpServlet  {
    CmService service;
    String url;

    public PhoneController() {
        super();
        service = new CmService();
        url = "";
    }


/*
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
            if (action.equals("list")) {
                List<Phone> phones = service.findAllPhones();
                request.setAttribute("phones", phones);
                url = "listPhone.jsp";
            }

            if (action.equals("new")) {
                url = "newPhone.jsp";
            }
        }

            if(method.equals("POST")) {
                // Create Action
                if(action.equals("create")) {

                    Integer id = 0;
                    String number = request.getParameter("number");
                    String type = request.getParameter("type");
                    String operator = request.getParameter("operator");

                    Phone phone= service.createPhone(number,type, operator);

                    List<Phone> phones = service.findAllPhones();
                    request.setAttribute("phones", phones);
                    url = "listPhone.jsp";
                }


                if(action.equals("update")) {
                    Integer id=0;
                    String number = request.getParameter("number");
                    String type = request.getParameter("type");
                    String operator = request.getParameter("operator");
                    // boolean isUpdated = service.updateCustomer(id, name);
                    List<Phone> phones= service.findAllPhones();
                    request.setAttribute("customer", phones);
                    url = "listPhones.jsp";
                }
            }

        request.getRequestDispatcher(url).forward(request, response);

    }

*/



}
