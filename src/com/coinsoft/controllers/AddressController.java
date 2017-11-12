package com.coinsoft.controllers;
import com.coinsoft.models.CmService;
import com.coinsoft.models.Address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "AddressController", urlPatterns = "/address")
public class AddressController extends javax.servlet.http.HttpServlet {

         CmService service;
         String url;

        public AddressController() {
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
                   // List<Address> addresses = service.findAllAddress();
                   // request.setAttribute("address", addresses);
                    url = "listAddress.jsp";
                }
                if(action.equals("show")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    //Address address = service.findAddressById(id);
                    //request.setAttribute("address",address);
                    url = "showAddress.jsp";
                }
                if(action.equals("new")) {
                    url = "newAddress.jsp";
                }
                if(action.equals("edit")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                   // Address address = service.findAddressById(id);
                   // request.setAttribute("address", address);
                    url = "editAddress.jsp";
                }
            }

            if(method.equals("POST")) {
                // Create Action
                if(action.equals("create")) {
                    String name = request.getParameter("name");
                  //  Address address = service.createAddress(name);
                  //  List<Address> addresses = service.findAllAddress();
                  //  request.setAttribute("address", addresses);
                    url = "listAddress.jsp";
                }
                if(action.equals("update")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");
                  //  boolean isUpdated = service.updateAddress(id, name);
                  //  List<Address> addresses = service.findAllAddress();
                  //  request.setAttribute("addresses", addresses);
                    url = "listAddress.jsp";
                }
            }

            request.getRequestDispatcher(url).forward(request, response);
        }





    }
