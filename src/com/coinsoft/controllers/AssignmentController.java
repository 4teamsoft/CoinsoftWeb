package com.coinsoft.controllers;
/*
@javax.servlet.annotation.WebServlet(name = "AssignmentController", urlPatterns = "/assignment")
public class AssignmentController  extends javax.servlet.http.HttpServlet {
    CmService service;
    String url;
    public AssignmentController() {
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
                List<Assignment> assignments = service.findAllAssignments();
                request.setAttribute("assignment", assignments);
                url = "listAssignment.jsp";
            }
            if(action.equals("show")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Assignment assignment = service.findAssignmentById(id);
                request.setAttribute("assignment",assignment);
                url = "showAssignment.jsp";
            }
            if(action.equals("new")) {
                url = "newAssignment.jsp";
            }
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Assignment assignment = service.findAssignmentById(id);
                request.setAttribute("assignment", assignment);
                url = "editAssignment.jsp";
            }
        }
        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
               // Assignment address = service.createAssignment(name);
                List<Assignment> assignments = service.findAllAssignments();
               request.setAttribute("assignment", assignments);
                url = "listAssignment.jsp";
            }
            if(action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
               // boolean isUpdated = service.updateAssignment(id, name);
                List<Assignment> assignments = service.findAllAssignments();
                request.setAttribute("assignments", assignments);
                url = "listAssignment.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}*/
