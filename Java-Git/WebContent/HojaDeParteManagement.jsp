<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Factura" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>

<link href="style/css/tabla.css" rel="stylesheet">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/cover/">
<!-- Bootstrap core CSS -->
<link href="style/css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<link rel="stylesheet" href="style/css/bootstrap.css">
<link href="style/css" type="text/css" rel="stylesheet">
</head>
<body>

<h1 style="text-align: center;">Listado de hojas de parte</h1>
<form action = "listadohojasdeparte" method = "GET" >
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Nro</th>
      <th scope="col">Costo mano de obra</th>
      <th scope="col">Mecanico</th>
      <th scope="col">Nro Factura</th>
      <th scope="col">Patente </th>
      <th scope="col">Operaciones</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${listaHojaDeParte}" var="h">
    <tr>
   	<input id = "idHoja" name = "idHoja" type="hidden" value="${h.getID()}" ">	
 	<input id = "costoManoDeObra" name = "costoManoDeObra"  type="hidden"  value = "${h.getCostoManoDeObra()}">	
   	<input id = "idMecanico"  name = "idMecanico" type="hidden" value = "${h.getMecanico().getID()}">
 	<input name = "idFactura" id = "idFactura" type="hidden"  value = "${h.getFactura().getID()}" >
 	<input name = "idAuto" id = "idAuto" type="hidden"  value = "${h.getAutomovil().getID()}">
 	  	
      <th scope="row"><c:out   value = "${h.getID()}"/><p></th>
      <td><c:out value = "${h.getCostoManoDeObra()}"/><p></td>
      <td><c:out value = "${h.getMecanico()}"/><p></td>
      <td><c:out value = "${h.getFactura().getID()}"/><p></td>
      <td><c:out value = "${h.getAutomovil().getID()}"/><p></td>
      <td>
      	
      		<c:if test="${idf != null}">
      		<a href="listadohojasdeparte?id=${h.getID()}&idFactura=${idf}&modo=edit"><button  type="Button"  class="btn btn-info">Editar</button></a>
      		<a href="listadohojasdeparte?id=${h.getID()}&idFactura=${idf}&modo=delete"><button  type="Button"  class="btn btn-danger">Baja</button></a>	
      		</c:if>
      		<c:if test="${idf == null}">
      		<a href="listadohojasdeparte?id=${h.getID()}&modo=edit"><button  type="Button"  class="btn btn-info">Editar</button></a>
      		<a href="listadohojasdeparte?id=${h.getID()}&modo=delete"><button  type="Button"  class="btn btn-danger">Baja</button></a>	
      		</c:if>
      	
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>
 <a href='menu'><button type="Button" class="btn btn-primary">Volver</button></a>
 	
<a href="listadohojasdeparte?modo=new&idFactura=${idf}"><button type="Button" class="btn btn-secondary">Agregar hoja</button></a>


  </form>





</body>
</html>