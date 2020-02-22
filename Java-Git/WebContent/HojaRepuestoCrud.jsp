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
<script src="style/js/jquery-3.4.1.min.js">  </script>

<title>Factura</title>



</head>
<body>

<form action="hojarepuesto" name = 'form' >
<input id = "modo" name = "modo" type="hidden" value="${modo}"  >	
		<div class="row">
		<!-- Campo idHojaDeParte -->
  			<div class="col"> 
				<div class="col-sm-10">
      				Hoja de parte nro :<input type="text" class="form-control" name = "idHoja" id="idHoja" value="${hoja.getID()}"  readonly>
  				</div>
  			</div>
  			<div class="col"> 
  			</div>
  			<div class="col"> 
  			</div>
  			<div class="col"> 
  			</div>
  			
  	  	 </div>
  	  	 
  	  	 <!-- Campo lista de repuestos -->
  	  	<div class="row">
  	  		<c:if test ="${modo == 'new' }"> 
  	  			<div class="col" align="left" >
  	  				<div class="col-sm-10">	
			     	Repuesto :
			     		<select name="repuestosLista" id="repuestosLista" class="custom-select custom-select-lg mb-3" >
						<option selected value = "0">Seleccionar repuesto</option>
						<c:forEach items="${listaRepuestos}" var="rep">
							<option id = repuestoIDLista value="${rep.getID()}" >${rep.getDescripcion()}</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</c:if>
			<c:if test ="${modo == 'edit'}"> 
			<div class="col">
  				
  					<div class="col-sm-10">
  					<input id = "idRepuesto" name = "idRepuesto" type="hidden" value="${repuesto.getID()}" readonly>	
  						Repuesto:<input type="text" class="form-control" id = "repuesto" name = "repuesto"   value="${repuesto.getDescripcion()}" readonly  >
  					</div>
  			
  	  	 	</div>
  	  	 	</c:if>
			<!-- Campo Cantidad -->
			<div class="col">
  				<c:if test ="${modo == 'new' or modo == 'edit'}" > 
  					<div class="col-sm-10">
  						Cantidad:<input type="text" class="form-control" id = "cantidad" name = "cantidad"  value="${hojarepuesto.getCantidad()}"  >
  					</div>
  				</c:if>
  	  	 	</div>
  	  	 	<!-- Campo PrecioTotal 
  	  	 	<div class="col">
	  				<c:if test ="${modo == 'edit'}" > 
	  					<div class="col-sm-10">
	  						Precio total:<input type="text" class="form-control" id = "precioTotal" name = "precioTotal"  value="${hojarepuesto.getPrecioTotal()}"  readonly>
	  					</div>
	  				</c:if>
	  				<c:if test ="${modo == 'new'}" > 
	  					<div class="col-sm-10">
	  						Precio total:<input type="text" class="form-control" id = "precioTotalN" name = "precioTotal"   readonly>
	  					</div>
	  				</c:if>
	  	  	 </div>-->
  	  	 	
  	  	 	
			</div>
			
			<div align="center">
			
				<button type="Button"  id = "btnConfirmar" onclick="valida();"  class="btn btn-primary" >Confirmar</button>
				<a href="/Java-Git/menu?page=listahojasrepuestos&idhoja=${hoja.getID()}"><button type="button" class="btn btn-secondary">Volver</button></a>
		
			</div>
		
	</form>
	
<script type = "text/javascript">

function valida()
{   var cantidad = document.getElementById("cantidad");
	
	
	x = true;
	if(document.getElementById("repuestosLista") != null )
	{if(document.getElementById("repuestosLista").value == '0'){
   		alert("Debe seleccionar un repuesto");
   	 	x = false;
	}
	}
	if(cantidad.value == 0)
	{
   		alert("Debe ingresar la cantidad");
   	 	x = false;
	}
	
	if (!/^([0-9])*$/.test(cantidad.value))
	{
		alert("El valor de la cantidad no es un número valido");
		x = false;
	}
	
	if(x == true)
		{
		 doPost();
		}
}

function doPost()
{
    $.post("hojarepuesto", {
        idHoja		  : document.getElementById("idHoja").value,
        repuestosLista: document.getElementById("repuestosLista") != null ? document.getElementById("repuestosLista").value : "0",
        idRepuesto    : document.getElementById("idRepuesto") !=null ? document.getElementById("idRepuesto").value : "0" ,
        cantidad      : document.getElementById("cantidad").value,
        modo		  : document.getElementById("modo").value
   			}).done(function (responseText) {
            if (responseText.trim() != '') { 
            	 window.location.reload();
            	 alert(responseText  ); 
           }else
        	   {
        	   window.location.replace("menu?page=listahojasrepuestos&idhoja="+ document.getElementById("idHoja").value );
        	   }

        }).fail(function (data, textStatus, xhr) {
            //This shows status code eg. 403
            console.log("error", data.status);
            //This shows status message eg. Forbidden
            console.log("STATUS: " + xhr);
        })
}

</script>

</body>
</html>