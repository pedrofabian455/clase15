/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme;

import com.acme.dao.ContactoDAO;
import com.acme.dao.ContactoDAOImpl;
import com.acme.model.Contacto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author JuaN
 */
@WebServlet(urlPatterns = "/ContactoServlet")
public class ContactoServlet extends HttpServlet {

    // Se define el objeto "contactoDao" de clase ContactoDAO.
    private ContactoDAO contactoDao;

    public ContactoServlet() {
        super();
        // Se instancia la clase ContactoDAOImpl.
        contactoDao = new ContactoDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.procesarSolicitud(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.procesarSolicitud(req, resp);
    }

    protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se redirecciona de acuerdo a la petición
        switch (request.getParameter("action")) {
            case "list":
                 this.list(request, response);
                break;
            case "create":
                this.create(request, response);
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
                this.showRegister(request, response);
                break;
            case "index":
                this.index(request, response);
                break;
            default:
                this.index(request, response);
                break;
        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Se redirecciona al JSP "index.jsp", es decir la pagina principal.
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se redirecciona al JSP "create.jsp" para mostrar el formulario de registro.
        RequestDispatcher dispacther = request.getRequestDispatcher("/view/create.jsp");
        dispacther.forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se recogen los datos desde la peticion.
        String name = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String descrip = request.getParameter("descripcion");

        // Se crea el objeto que se envia al BD.
        Contacto objContacto = new Contacto();
        objContacto.setNombre(name);
        objContacto.setApellido(apellido);
        objContacto.setEmail(email);
        objContacto.setDescripcion(descrip);

        // Se envia el objeto para insertar en la BD.
        contactoDao.insert(objContacto);

        // Se ejecuta el método "index" para redireccionar al JSP "index.jsp"
        this.index(request, response);
    }
    
    private void list(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        List<Contacto> listaContactos = this.contactoDao.findAll();
        
        request.setAttribute("lista", listaContactos);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
        dispatcher.forward(request, response);
    }
}
