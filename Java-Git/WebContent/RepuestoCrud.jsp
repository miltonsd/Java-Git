<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Repuesto" %>
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

<script>
function valida()
{
	var ok = true;
	var descripcion	   = document.getElementById("descripcion").value;
	var precioUnitario = document.getElementById("precioUnitario").value;
	var cuit		   = document.getElementById("cuit").value;
	
    if (!/^([0-9])*$/.test(cuit))
     {
    	 alert("El valor del " + cuit + " no es un número")
     	 ok = false;
      }
    var RE = /^\d*\.?\d*$/;
	if (RE.test(precioUnitario)) {
	       ok = true;
	    }	else {
	    	alert("El valor " + precioUnitario + " no es valido")
	     	 ok = false;
	    }
	if(ok == false)
	{
    
     }
	else
	{
	  myForm.submit();
	}
	      
}

</script>
<title>Repuesto</title>
</head>
<body>
<form action="repuesto" method="POST" id = "myForm" >
<input id = "modo" name = "modo" type="hidden" value="${modo}" >	
<input id = "id" name = "id" type="hidden" value="${repuesto.getID()}" >	
		<div class="row">
			<div class="col">
				<div class="col-sm-10">
      				ID Repuesto :<input type="text" class="form-control" name = "idRepuesto"  value="${idr}" readonly >
  				</div>
  			</div>
  			<div class="col">			
  					<div class="col-sm-10">
  						Descripcion :<input type="text" class="form-control" id = "descripcion" name = "descripcion"  value="${repuesto.getDescripcion()}" required="required"   >
  					</div>
  	  	 	</div>
  	  	 </div>
  	  	 
  	  	 <div class="row">
  	  	 	<div class="col">
  					<div class="col-sm-10"> 					
  							Precio unitario :<input type="text" class="form-control" id = "precioUnitario"  name = "precioUnitario" value="${repuesto.getPrecioUnitario()}"  onChange="validateDecimal(this.value);" required="required"  >
  					</div>
  	  		
  	  		</div>
  	  		<div class="col">
   	  				<div class="col-sm-10">
  							Stock :<input type="text" class="form-control" name = "stock"  value="${repuesto.getStock()}" required="required"   >
  					</div>
  			</div>
  	 	</div>
  	 
  	  	<div class="row">
  	  		<div class="col">
  	  				<div class="col-sm-10">	
  										
  						Proveedor :<select name="proveedoresLista" class="custom-select custom-select-lg mb-3">
			     		<c:if test = '${modo == "new"}'>
						<option selected value = "0"  >Seleccionar proveedor</option>
						</c:if>
						<c:if test = '${modo == "edit"}'>
						<option selected value = "${proveedor.getID()}" >${proveedor.getID()} - ${proveedor.getRazonSocial()}</option>
						</c:if>
						<c:forEach items="${listaProveedor}" var="prov">
							<option id = listaProveedorID value="${prov.getID()}">${prov.getID()} - ${prov.getRazonSocial()}</option>
						</c:forEach>
					</select>
	
  					
  					</div>	
  	  		</div>
  	  	
  	  			<div class="col" align="left">
  	  			<div class="col-sm-10">	
			     		Tipo repuesto :<select name="tipoRepuestoLista" class="custom-select custom-select-lg mb-3">
			     		<c:if test = '${modo == "new"}'>
						<option selected value = "0"  >Tipo de repuestos</option>
						</c:if>
						<c:if test = '${modo == "edit"}'>
						<option selected value = "${tiporepuesto.getID()}"  >${tiporepuesto.getID()} - ${tiporepuesto.getDescripcion()}</option>
						</c:if>
						<c:forEach items="${listaTipoRepuesto}" var="tr">
							<option id = tipoRepuestoIDLista value="${tr.getID()}">${tr.getID()} - ${tr.getDescripcion()}</option>
						</c:forEach>
					</select>
				</div>	
				</div>

		</div>
			<div align="center">
				<button type="Button"  class="btn btn-primary" onClick = "valida();">Confirmar</button>
				<a href="menu?page=listarepuestos"><button type="button" class="btn btn-secondary">Volver</button></a>
			</div>
	</form>
</body>
</html>