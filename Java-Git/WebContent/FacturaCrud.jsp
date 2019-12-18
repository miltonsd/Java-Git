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
<c:if test="${modo =='edit'}">
<div align="Left">
<a href="menu?page=listahojasdeparte&idFactura=${idf} "><button type="Button"  class="btn btn-primary">Hojas de parte</button></a>
</div>
</c:if>
<form action="factura" method="POST">
<input id = "modo" name = "modo" type="hidden" value="${modo}" >	
		<div class="row">
			<!-- Campo idFactura -->
			<div class="col"> 
				<div class="col-sm-10">
      				Factura nro :<input type="text" class="form-control" name = "idFactura"  value="${idf}"  readonly>
  				</div>
  			</div>
  			
  			<!-- Campo FechaEmision -->
  			<div class="col">
  				<c:if test ="${factura.getFechaEmision() != null}" > 
  					<div class="col-sm-10">
  						Fecha de emision :<input type="text" class="form-control" name = "fechaEmision"  value="${factura.getFechaEmision()}"  readonly>
  					</div>
  	  			</c:if>
  	  			<c:if test ="${factura.getFechaEmision() == null}" > 
  					<div class="col-sm-10">
  						Fecha de emision :<input type="text" class="form-control" name = "fechaEmision"  value="Sin emitir"  readonly>
  					</div>
  	  			</c:if>
  	  	 	</div>
  	  	 </div>
  	  	 
  	  	 <!-- Campo ImporteTotal -->
  	  <div class="row">
  	  	 	<div class="col">
  	  			
  					<div class="col-sm-10">
  							Importe total :<input type="text" class="form-control"  name = "importeTotal" value="${factura.getImporteTotal()}"  readonly>
  					</div>
  	  		</div>		
  		 <!-- Campo Usuario -->
  			<c:if test ="${modo == 'emitir'}"> 
  	  		<div class="col">
  	  				<div class="col-sm-10">
  	  					
  							Cliente :<input type="text" class="form-control" name = "cliente"  value="${usuario.getDni()} - ${usuario.getApellido()}, ${usuario.getNombre()}"  readonly>
  						
  					</div>	
  	  		</div>
  	  		</c:if>
  	  		<c:if test ="${modo == 'new' or modo == 'edit'}"> 
  	  			<div class="col" align="left" >
  	  				<div class="col-sm-10">	
			     	Cliente :
			     		<select name="usuariosLista" class="custom-select custom-select-lg mb-3">
						<c:if test ="${modo == 'new'}"> 
							<option selected value = "0" >Seleccionar cliente</option>
						</c:if>
						<c:if test ="${modo == 'edit'}"> 
							<option selected value = "${usuario.getID()}" >${usuario.getDni()}-${usuario.getApellido()}, ${usuario.getNombre()}</option>
						</c:if>
						<c:forEach items="${listaUsuarios}" var="usu">
							<option id = usuarioIDLista value="${usu.getID()}">${usu.getDni()}-${usu.getApellido()}, ${usu.getNombre()}</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</c:if>
			
		</div>
		

		
			<div align="center">
				<button type="Submit" name = "btnConfirmar" id = "btnConfirmar" value ="${modo}" class="btn btn-primary">Confirmar</button>
				<a href="menu?page=listafacturas"><button type="button" class="btn btn-secondary">Volver</button></a>
			</div>
			
	</form>
</body>
</html>