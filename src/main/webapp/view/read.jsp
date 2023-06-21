<%-- 
    Document   : read
    Created on : Jun 17, 2023, 2:19:05 PM
    Author     : JuaN
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Actualizar Contacto</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script defer src="<%= request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-info-subtle">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">PV</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Contacto</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h1 class="text-center text-primary">Actualizar Contacto</h1>
        <div class="container">
            <form action="<%= request.getContextPath() %>/ContactoServlet?action=update" method="POST">
                <input type="hidden" name="id" requerid placeholder="idContacto" value='<c:out value="$[contacto.id}"></c:out>'>
                <div class="mb-3">
                    <label for="nombre" class="form-label"> Nombre:</label> 
                    <input type="text" class="form-control"  name="nombre" id="nombre" required minlength="1" maxlength="100" placeholder="Nombre del Contacto" value='<c:out value="$[contacto.nombre}"></c:out>'>
                </div>
                <div class="mb-3">
                    <label for="apellido" class="form-label">Apellido:</label>
                    <input type="text" class="form-control" name="apellido" id="apellido" required minlength="1" maxlength="100" placeholder="Apellido del Contacto" value='<c:out value="$[contacto.apellido}"></c:out>'/>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" class="form-control" name="email" id="email" required minlength="6" maxlength="50" placeholder="micorreo@mail.com" value='<c:out value="$[contacto.email}"></c:out>'/>
                </div>
                <div class="mb-3">
                    <label for="descripcion" class="form-label" >Descripción:</label>
                    <input type="text" class="form-control" name="descripcion" id="descripcion" required minlength="1" maxlength="100" placeholder="Breve descripción" value='<c:out value="$[contacto.id}"></c:out>' />
                </div>
                <button type="submit" class="btn btn-primary">Actualizar</button>
            </form>
        </div>
    </body>
</html>
