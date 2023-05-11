/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme;

import com.acme.dao.ContactoDAO;
import com.acme.dao.ContactoDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author JuaN
 */
@WebServlet(urlPatterns = "/ContactoServlet")
public class ContactoServlet extends HttpServlet {

    private ContactoDAO contactoDao;

    public ContactoServlet() {
        super();
        contactoDao = new ContactoDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String emailId = req.getParameter("emailId");
        String telefono = req.getParameter("telefono");
        String descripcion = req.getParameter("descripcion");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String descripcion = req.getParameter("descripcion");
    }

    protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "list":
                // this.list(request, response);
                break;
            case "create":
                //this.create(request, response);
                break;
            case "read":
                // this.read(request, response);
                break;
            case "update":
                //this.update(request, response);
                break;
            case "delete":
                // this.delete(request, response);
                break;
            case "showRegister":
                //this.showRegister(request, response);
                break;
            case "index":
                this.index(request, response);
                break;
            default:
               this.index(request, response);
                break;
        }
        
    }
        private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

}
