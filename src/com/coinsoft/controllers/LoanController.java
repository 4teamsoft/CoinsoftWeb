package com.coinsoft.controllers;

import  com.coinsoft.models.CmService;
import com.coinsoft.models.Loan;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@javax.servlet.annotation.WebServlet(name = "EmployeeController", urlPatterns = "/employe")

public class LoanController extends javax.servlet.http.HttpServlet {

    CmService service;
    String url;

    public LoanController() {
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
                List<Loan> loans = service.findAllLoans();
                request.setAttribute("loans", loans);
                url = "listLoan.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Loan loan = service.findLoanById(id);
                request.setAttribute("loan",loan);
                url = "showLoan.jsp";
            }
            if(action.equals("new")) {
                url = "newLoan.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Loan loan = service.findLoanById(id);
                request.setAttribute("loan", loan);
                url = "editLoan.jsp";
            }
        }

        /*if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
                 Loan loan = service.createLo(name);
                List<Loan> loans = service.findAllLoans();
                request.setAttribute("employee", loans);
                url = "listLoans.jsp";
            }

            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateEmployee(id, name);
                List<Employe> employes = service.findAllEmployes();
                request.setAttribute("employe", employes);
                url = "listEmploye.jsp";
            }
        }
*/
        request.getRequestDispatcher(url).forward(request, response);
    }













}
