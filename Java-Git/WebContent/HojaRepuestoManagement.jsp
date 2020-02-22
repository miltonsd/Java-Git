<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.HojaRepuesto" %>
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

<h1 style="text-align: center;">Listado de hojas de repuestos</h1>
<form action = "listadohojasdeparte" method = "GET" >
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Nro</th>
      <th scope="col">Repuesto</th>
      <th scope="col">Cantidad</th>
      <th scope="col">Precio total</th>
      <th scope="col">Operaciones</th>
    </tr>
  </thead>
  <tbody>
 <input id = "emitido" name = "emitido" type="hidden" value="${emitido}" readonly>	
 <input id = "idFactura" name = "idFactura" type="hidden" value="${idf}" readonly>	
 <input id = "idHoja" name = "idHoja" type="hidden" value="${idh}" readonly>	
 <c:forEach items="${listaHojaRepuesto}" var="hr" varStatus="count">
    <tr>
   	
 	<input id = "descripcionRepuesto" name = "descripcionRepuesto"  type="hidden"  value = "${hr.getRepuesto().getDescripcion()}" readonly>	
   	<input id = "cantidad"  name = "cantidad" type="hidden" value = "${hr.getCantidad()}" readonly>
 	<input name = "precioTotal" id = "precioTotal" type="hidden"  value = "${h.getFactura().getID()}" readonly>
 	
 	
      <td><c:out value = "${count.index + 1}"/><p></td>
      <td><c:out value = "${hr.getRepuesto().getDescripcion()}"/><p></td>
      <td><c:out value = "${hr.getCantidad()}"/><p></td>
      <td><c:out value = "${hr.getPrecioTotal()}"/><p></td>
      <td>
     	<c:if test="${emitido == false}">
 		<a href="listadohojasrepuestos?modo=edit&idhoja=${idh}&idrepuesto=${hr.getRepuesto().getID()}"><button  type="Button"  class="btn btn-info">Editar</button></a>
   		<a href="listadohojasrepuestos?modo=delete&idhoja=${idh}&idrepuesto=${hr.getRepuesto().getID()}"><button  type="Button"  class="btn btn-danger">Baja</button></a>	
 		</c:if>
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>
  <a href='menu?page=listahojasdeparte&idfactura=${idf}'><button type="Button" class="btn btn-primary">Volver</button></a>
 
  <c:if test="${emitido == false}">
	<a href="listadohojasrepuestos?modo=new&idhoja=${idh}"><button type="Button" class="btn btn-secondary">Agregar repuesto</button></a>
	</c:if>
  </form>





</body>
</html>