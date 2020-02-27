<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Repuesto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>	
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>Taller Mecánico - Repuestos</title>
		<link rel="shortcut icon" href="style/img/logo.png">			
    <link href="style/css/tabla.css" rel="stylesheet">
    <link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script>
    	function tipoRepuestoLista() {
        var x = document.getElementById("tipoRepuestoLista").value;
        window.location.href = "/Java-Git/menu?page=listarepuestos&tiporepuesto=" + x;
      }
    </script>
	</head>
	<body>
    <div class="col-sm-10">
    	Tipo repuesto :
    	<select name="tipoRepuestoLista" onchange="tipoRepuestoLista()" id="tipoRepuestoLista"
          		class="custom-select custom-select-lg mb-3">
      	<c:if test='${tre == null || tre.getID() == 0}'>
        	<option selected value="0">*Todos</option>
      	</c:if>
      	<c:if test='${tre != null && tre.getID() != 0}'>
        	<option selected value="${tre.getID()}">${tre.getID()} - ${tre.getDescripcion()}</option>
      		<c:if test='${tre.getID() != 0}'>
        		<option value="0">*Todos</option>
      		</c:if>
      	</c:if>
      	<c:forEach items="${listaTipoRepuesto}" var="tr">
        	<option id="tipoRepuestoListaSelec" value="${tr.getID()}">
        		${tr.getID()} - ${tr.getDescripcion()}
        	</option>
      	</c:forEach>
     	</select>
    </div>
    <h1 style="text-align: center;">Listado de Repuestos</h1>
    <form action="listadorepuestos" method="GET">
    	<table class="table table-striped">
        <thead>
        	<tr>
            <th scope="col">ID</th>
            <th scope="col">Descripción</th>
            <th scope="col">Precio Unitario</th>
            <th scope="col">Stock</th>
            <th scope="col">Tipo de repuesto</th>
            <th scope="col">Proveedor</th>
           	<th scope="col">Opciones</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listaRepuestos}" var="r">
            <tr>
            	<th scope="row"><c:out value="${r.getID()}"/><br></th>
              <td><c:out value="${r.getDescripcion()}"/><br></td>
              <td><c:out value="${r.getPrecioUnitario()}"/><br></td>
              <td><c:out value="${r.getStock()}"/><br></td>
              <td><c:out value="${r.getTipoRepuesto().getDescripcion()}"/><br></td>
              <td><c:out value="${r.getProveedor().getID()}"/><br></td>
              <td>
                <a href="listadorepuestos?id=${r.getID()}&modo=edit"><button type="Button"
                   class="btn btn-info">Editar</button></a>
                <a href="listadorepuestos?id=${r.getID()}&modo=delete"><button type="Button"
                   class="btn btn-danger">Baja</button></a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href='menu'><button type="Button" class="btn btn-primary">Volver</button></a>
      <a href="listadorepuestos?&modo=new"><button type="Button" class="btn btn-secondary">Agregar Repuesto</button></a>
    </form>
	</body>
</html>