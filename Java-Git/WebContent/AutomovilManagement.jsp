<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Automovil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link href="style/css/tabla.css" rel="stylesheet">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">
    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="style/css/bootstrap.css">
    <link href="style/css" type="text/css" rel="stylesheet">
    <script src="style/js/jquery-3.4.1.min.js">  </script>
    <script type="text/javascript">
    function borrarAutomovil(x) {
        var id = "#btnEliminar" + x;

        $.post("listaautomoviles", {
            patente: x,
            modo: "delete",
    
       			}).done(function (responseText) {
                if (responseText.trim() != '') { alert(responseText); }
                else { alert('Automovil eliminado'); }

            }).fail(function (data, textStatus, xhr) {
                //This shows status code eg. 403
                console.log("error", data.status);
                //This shows status message eg. Forbidden
                console.log("STATUS: " + xhr);
            }).always(function () {
                window.location.reload();
            });
           
    }
    </script>
</head>

<body>
    <h1 style="text-align: center;">Listado de Vehiculos</h1>
    <form action="listadoautomoviles" method="GET">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Patente</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">DNI</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Modelo</th>
                    <th scope="col">Color</th>
                    <th scope="col">Operaciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaAutomoviles}" var="a">
                    <tr>
                        <input id="Usuario" name="Usuario" type="hidden" value="${a.getCliente()}" ">	
 						<input id = "patente" name="patente" type="hidden" value="${a.getID()}">	
   						<input id = "dni" name="dni" type="hidden" value="${a.getCliente().getDni()}">
                        <input name="Marca" id="Marca" type="hidden" value="${a.getMarca()}">
                        <input name="Modelo" id="Modelo" type="hidden" value="${a.getModelo()}">
                        <input name="Color" id="Color" type="hidden" value="${a.getColor()}">

                        <th scope="row">
                            <c:out value="${a.getID()}" />
                            <p>
                        </th>
                        <td>
                            <c:out value="${a.getCliente()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${a.getCliente().getDni()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${a.getMarca()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${a.getModelo()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${a.getColor()}" />
                            <p>
                        </td>
                        <td>                        
                           
                                <a href="listaautomoviles?patente=${a.getID()}&modo=edit"><button type="Button"
                                        class="btn btn-info">Editar</button></a>
 								<button id="btnEliminar${a.getID()}" value="${a.getID()}" type="Button"
                                    onclick="borrarAutomovil('${a.getID()}');" class="btn btn-danger">Baja</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href='menu'><button type="Button" class="btn btn-primary">Volver</button></a>
        <a href="listaautomoviles?modo=new"><button type="Button" class="btn btn-secondary">Agregar vehiculo</button></a>
        
    </form>
</body>

</html>