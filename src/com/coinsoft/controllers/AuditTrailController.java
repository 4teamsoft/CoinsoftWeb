package com.coinsoft.controllers;

import com.coinsoft.models.CmService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@javax.servlet.annotation.WebServlet(name = "AssignmentController", urlPatterns = "/assignment")
public class AuditTrailController  extends javax.servlet.http.HttpServlet {


    CmService service;
    String url;

    public AuditTrailController() {
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
/*
        if(method.equals("GET")) {
            // Index Action
            if(action.equals("index")) {
                List<AuditTrail> auditTrails = service.findAllAuditTrail();
                request.setAttribute(" auditTrail", auditTrails);
                url = "listAuditTrail.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                AuditTrail auditTrail = service.findAuditTrailById(id);
                request.setAttribute("auditTrail",auditTrail);
                url = "showAuditTrail.jsp";
            }
            if(action.equals("new")) {
                url = "newAuditTrail.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                AuditTrail auditTrail = service.findAuditTrailById(id);
                request.setAttribute("auditTrail", auditTrail);
                url = "editAuditTrail.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
                AuditTrail auditTrail = service.createAuditTrail(name);
                List<AuditTrail> assignments = service.findAllAuditTrail();
                request.setAttribute("auditTrail", auditTrail);
                url = "listAuditTrail.jsp";
            }
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                boolean isUpdated = service.updateAuditTrail(id, name);
                List<AuditTrail> auditTrails = service.findAllAuditTrail();
               request.setAttribute("auditTrail", auditTrails);
                url = "listAuditTrail.jsp";
            }
        }

        request.getRequestDispatcher(url).forward(request, response);*/
    }


}
