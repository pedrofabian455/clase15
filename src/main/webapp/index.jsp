<%-- 
    Document   : index
    Created on : May 10, 2023, 9:42:12 PM
    Author     : JuaN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="container" text="center"> 
            <div class="row">
                <div class="col-sm-6 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
  <img src="assets/img/contacto.png" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Registrar Contacto</h5>
    <p class="card-text">Formulario para anadir un nuevo contacto</p>
    <a href="<%= request.getContextPath() %>/ContactoServlet?action=showRegister" class="btn btn-primary">Registrar</a>
  </div>
</div>
            </div>
        </div>
    </body>
</html>
