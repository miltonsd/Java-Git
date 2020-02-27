<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Automovil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Taller Mecánico - Automóviles</title>
    <link rel="shortcut icon" href="style/img/logo.png">
    <link href="style/css/tabla.css" rel="stylesheet">
    <link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
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
    <h1 style="text-align: center;">Listado de Vehículos</h1>
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
            	<th scope="row"><c:out value="${a.getID()}"/><br></th>
              <td><c:out value="${a.getCliente()}"/><br></td>
              <td><c:out value="${a.getCliente().getDni()}"/><br></td>
              <td><c:out value="${a.getMarca()}"/><br></td>
              <td><c:out value="${a.getModelo()}"/><br></td>
              <td><c:out value="${a.getColor()}"/><br></td>
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