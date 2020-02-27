<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>Taller Mecánico - Usuarios</title>
		<link rel="shortcut icon" href="style/img/logo.png">	
		<link href="style/css/tabla.css" rel="stylesheet">
		<link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	</head>
	<body>
  	<h1 style="text-align: center;">Listado de Usuarios</h1>
    <form action="listausers" method="GET">
    	<table class="table table-striped">
      	<thead>
        	<tr>
          	<th scope="col">ID</th>
            <th scope="col">Nombre y Apellido</th>
            <th scope="col">DNI</th>
            <th scope="col">Usuario</th>
            <th scope="col">Email</th>
            <th scope="col">Teléfono</th>
            <th scope="col">Habilitado</th>
            <th scope="col">Operaciones</th>
          </tr>
   			</thead>
        <tbody>
        	<c:forEach items="${listaUsers}" var="u">
          	<tr>
            	<th scope="row"><c:out value="${u.getID()}"/><br></th>
            	<td scope="row"><c:out value="${u.getNombre()} ${u.getApellido()}"/><br></td>
            	<td scope="row"><c:out value="${u.getDni()}"/><br></td>
            	<td scope="row"><c:out value="${u.getUser()}"/><br></td>              
            	<td scope="row"><c:out value="${u.getEmail()}"/><br></td>
            	<td scope="row"><c:out value="${u.getTel()}"/><br></td>
            	<td scope="row">
            		<c:choose>
    							<c:when test="${u.getHabilitado()}">Si<br/></c:when>    
    							<c:otherwise>No<br/></c:otherwise>
								</c:choose>
              </td>
							<td>                                     
              	<a href="listausers?id=${u.getID()}&modo=edit"><button type="Button" class="btn btn-info">Editar</button></a>
 								<button id="btnEliminar${u.getID()}" value="${u.getID()}" type="Button" onclick="borrarUsuario('${u.getID()}');" class="btn btn-danger">Baja</button>
              </td>                                                                     
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href='menu'><button type="Button" class="btn btn-primary">Volver</button></a>
      <a href="listausers?modo=new"><button type="Button" class="btn btn-secondary">Agregar usuario</button></a>  
    </form>	
	</body>
</html>