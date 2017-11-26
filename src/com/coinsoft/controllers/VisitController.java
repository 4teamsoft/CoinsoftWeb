package com.coinsoft.controllers;

import  com.coinsoft.models.CmService;
import com.coinsoft.models.Customer;
import com.coinsoft.models.Visit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@javax.servlet.annotation.WebServlet(name = "VisitController", urlPatterns = "/visits")

public class VisitController extends javax.servlet.http.HttpServlet {

    CmService service;
    String url;

    public VisitController() {
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
                List<Visit> visits = service.findAllVisits();
                request.setAttribute("visits", visits);
                url = "listVisits.jsp";
            }

            if(action.equals("new")) {
                url = "newVisit.jsp";
            }
        }


        request.getRequestDispatcher(url).forward(request, response);
    }
}
