<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Factura" %>
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
<link href="style/css/bootstrap.min.css" type = "text/css" rel="stylesheet">
<link rel="stylesheet" href="style/css/bootstrap.css" >
<link href= "style/css"type = "text/css" rel="stylesheet">
<script type="text/javascript">
	function submitForm(met)
			{
    		document.myForm.action=met;
    		document.getElementById("myForm").submit();
    		}  
</script>
</head>

<body>
<h1 style="text-align: center;">Listado de Facturas</h1>
<form action= "miForm" >
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Nro</th>
      <th scope="col">Fecha emisión</th>
      <th scope="col">Cliente</th>
      <th scope="col">DNI</th>
      <th scope="col">Importe total</th>
      <th scope="col">Operaciones</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${listaFacturas}" var="f">
    <tr>
   	<input id = "idFactura" name = "idFactura" type="hidden" value="${f.getID()}" ">	
 	<input id = "fechaEmision" name = "fechaEmision"  type="hidden"  value = "${f.getFechaEmision() != null ? f.getFechaEmision() : 'Sin emitir'}" ">	
   	<input id = "anUsuario"  name = "anUsuario" type="hidden" value = "${f.getUsuario()}">
 	<input name = "importeTotal" id = "importeTotal" type="hidden"  value = "${f.getImporteTotal()}" >
 	<input name = "dniUsuario" id = "dniUsuario" type="hidden"  value = "${f.getUsuario().getDni()}">
 	  	
      <th scope="row"><c:out   value = "${f.getID()}"/><p></th>
      <td><c:out value = "${f.getFechaEmision() != null ? f.getFechaEmision() : 'Sin emitir'}"/><p></td>
      <td><c:out value = "${f.getUsuario()}"/><p></td>
      <td><c:out value = "${f.getUsuario().getDni()}"/><p></td>
      <td><c:out value = "${f.getImporteTotal()}"/><p></td>
      <td>
       	<a href="factura/display?id=${f.getID()}"><button  type="Button"  class="btn btn-info">Ver factura</button></a>
      	
      	<c:if test ="${f.getFechaEmision() == null}" >
      		<a href="factura/edit?id=${f.getID()}"><button  type="Button"  class="btn btn-info">Editar</button></a>
      		<a href="factura/delete?id=${f.getID()}"><button  type="Button"  class="btn btn-danger">Baja</button></a>
      		<c:if test ="${f.getImporteTotal() != 0}" > 
      			<a href="factura/emitir?id=${f.getID()}"><button  type="Button"  class="btn btn-success" name = "modo" id = "delete" value = 'emitir' >Emitir</button></a>
      		</c:if>
      	</c:if>		
      </td>
    </tr>
   </c:forEach>

  </tbody>
</table>
 <a href='JAVA-GIT/menu.jsp'><button type="Button" class="btn btn-primary">Volver</button></a>
<a href="factura/new?id=0"><button type="Button" class="btn btn-secondary">Agregar factura</button></a>
  </form>
</body>
</html>