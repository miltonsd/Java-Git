<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.HojaDeParte" %>
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
<a href="menu?page=listarepuestos&idFactura=${idf} "><button type="Button"  class="btn btn-primary">Repuestos</button></a>
</div>
</c:if>
<form action="hojadeparte" method="POST">
<input id = "modo" name = "modo" type="hidden" value="${modo}" >	
		<div class="row">
		<!-- Campo idFactura -->
  			<div class="col"> 
				<div class="col-sm-10">
      				Factura nro :<input type="text" class="form-control" name = "idFactura"  value="${idf}"  readonly>
  				</div>
  			</div>
  			
			<!-- Campo idHoja -->
			<div class="col"> 
				<div class="col-sm-10">
      				Hoja nro :<input type="text" class="form-control" name = "idHoja"  value="${idh}"  readonly>
  				</div>
  			</div>
  			
  			<!-- Campo CostoManoDeObra -->
  			<div class="col">
  				<c:if test ="${modo == 'new' or modo == 'edit'}" > 
  					<div class="col-sm-10">
  						Costo mano de obra:<input type="text" class="form-control" name = "costoManoDeObra"  value="${hoja.getCostoManoDeObra()}"  >
  					</div>
  				</c:if>
  	  	 	</div>
  	  	 </div>
  	  	 
  	  	<div class="row">
  	  		<c:if test ="${modo == 'new' or modo == 'edit'}"> 
  	  			<div class="col" align="left" >
  	  				<div class="col-sm-10">	
			     	Mecanico :
			     		<select name="usuariosLista" class="custom-select custom-select-lg mb-3">
						<c:if test ="${modo == 'new'}"> 
							<option selected value = "0" >Seleccionar Mecanico</option>
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
		<!-- Campo Automovil -->
		<c:if test ="${modo == 'new' or modo == 'edit'}"> 
  	  			<div class="col" align="left" >
  	  				<div class="col-sm-10">	
			     	Patente :
			     		<select name="patenteLista" class="custom-select custom-select-lg mb-3">
						<c:forEach items="${listaAutomoviles}" var="a">
							<option selected value = "${a.getID()}" >${a.getID()}</option>
							<option id = automovilIDLista value="${a.getID()}">${a.getID()}</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</c:if>
 
		</div>
			
		
			<div align="center">
				<button type="Submit" name = "btnConfirmar" id = "btnConfirmar" value ="${modo}" class="btn btn-primary">Confirmar</button>
				<a href="listadofacturas?id=4&modo=edit"><button type="button" class="btn btn-secondary">Volver</button></a>
			</div>
			
	</form>
</body>
</html>