<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Factura" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Taller Mecánico - Facturas</title>
    <link rel="shortcut icon" href="style/img/logo.png">
    <link href="style/css/tabla.css" rel="stylesheet">
    <link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">  
    	function submitForm(met) {
        document.myForm.action = met;
        document.getElementById("myForm").submit();
      }  
    </script>
	</head>
	<body>
  	<h1 style="text-align: center;">Listado de Facturas</h1>
    <form action="listadofacturas" method="GET">
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
              <th scope="row"><c:out value="${f.getID()}"/><br></th>
              <td><c:out value="${f.getFechaEmision() != null ? f.getFechaEmision() : 'Sin emitir'}"/><br></td>
              <td><c:out value="${f.getUsuario()}"/><br></td>
              <td><c:out value="${f.getUsuario().getDni()}"/><br></td>
              <td><c:out value="${f.getImporteTotal()}"/><br></td>
              <td>
                <a href="menu?page=listahojasdeparte&idfactura=${f.getID()}"><button type="Button" 
                   class="btn btn-info">Ver hojas</button></a>
        				<c:if test="${f.getFechaEmision() == null}">
                	<a href="listadofacturas?id=${f.getID()}&modo=edit"><button type="Button"
                     class="btn btn-info">Editar</button></a>
                  <a href="listadofacturas?id=${f.getID()}&modo=delete"><button type="Button"
                     class="btn btn-danger">Baja</button></a>
                  <c:if test="${f.getFechaEmision() == null}">
                  	<a href="listadofacturas?id=${f.getID()}&modo=emitir"><button type="Button"
                       class="btn btn-success">Emitir</button></a>
                  </c:if>               
                </c:if>
                <a href="listadofacturas?id=${f.getID()}&modo=report"><button type="Button"
                   class="btn btn-info">Reporte</button></a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href='menu'><button type="Button" class="btn btn-primary">Volver</button></a>
      <a href="listadofacturas?modo=new"><button type="Button" class="btn btn-secondary">Agregar factura</button></a>
    </form>
	</body>
</html>