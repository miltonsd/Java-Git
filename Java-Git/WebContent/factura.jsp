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
<title>Factura</title>
</head>
<body>
<form action="factura" method="POST">
<input id = "modo" name = "modo" type="hidden" value="${modo}" >	
		<div class="row">
			<div class="col">
				<div class="col-sm-10">
      				Factura nro :<input type="text" class="form-control" name = "idFactura"  value="${factura.getID()}"  readonly>
  				</div>
  			</div>
  			<div class="col">
  				<c:if test ="${factura.getFechaEmision() != null}" > 
  					<div class="col-sm-10">
  						Fecha de emision :<input type="text" class="form-control" name = "fechaEmision"  value="${factura.getFechaEmision()}"  readonly>
  					</div>
  	  			</c:if>
  	  	 	</div>
  	  	 </div>
  	  	 
  	  	 <div class="row">
  	  	 	<div class="col">
  	  			<c:if test ="${factura.getImporteTotal() != 0}" > 
  					<div class="col-sm-10">
  						<c:if test ="${modo == 'display' or 'delete' or 'emitir'}" > 
  							Importe total :<input type="text" class="form-control"  name = "importeTotal" value="${factura.getImporteTotal()}"  readonly>
  						</c:if>
  					</div>
  	  			</c:if>
  	  		</div>
  	  		<div class="col">
  	  			<c:if test ="${factura.getUsuario() != null}" >
  	  				<div class="col-sm-10">
  	  					<c:if test ="${modo == 'display' or 'delete' or 'emitir'}" > 
  							Usuario :<input type="text" class="form-control" name = "usuario"  value="${factura.getUsuario()}"  readonly>
  						</c:if>
  					</div>
  			    </c:if>
  			</div>
  	 	</div>
  	 
  	  	<div class="row">
  	  		<div class="col">
  	  			<c:if test ="${factura.getUsuario().getDni() != null}" >
  	  				<div class="col-sm-10">
  	  					<c:if test ="${modo == 'display' or 'delete' or 'emitir'}"> 
  							DNI :<input type="text" class="form-control" name = "dniUsuario"  value="${factura.getUsuario().getDni()}"  readonly>
  						</c:if>
  					</div>
  	  			</c:if>		
  	  		</div>
  	  		<c:if test ="${modo == 'new' or modo == 'edit' or 'emitir'}"> 
  	  			<div class="col" align="left">
			     		Asignar usuario :<select name="usuarioIdLista" class="custom-select custom-select-lg mb-3">
						<option selected value = "0"  >Usuarios</option>
						<c:forEach items="${listaUsuarios}" var="usu">
							<option id = usuarioIDLista value="${usu.getID()}">${usu.getDni()}-${usu}</option>
						</c:forEach>
					</select>
				</div>
			</c:if>
		</div>
			<div align="center">
				<button type="Submit" name = "btnConfirmar" id = "btnConfirmar" value ="${modo}" class="btn btn-primary">Confirmar</button>
				<a href="menu.jsp"><button type="button" class="btn btn-secondary">Volver</button></a>
			</div>
	</form>
</body>
</html>