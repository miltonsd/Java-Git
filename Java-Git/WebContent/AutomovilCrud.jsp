<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Automovil" %>
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

</head>
<body>

<form action="automovil" name = "form" >
<input id = "modo" type="hidden" value="${modo}" >	
		<div class="row">
			<!-- Campo Cliente -->
			<div class="col"> 
				<div class="col-sm-10">
				<c:if test ="${modo == 'new'}"> 
      				Patente :<input type="text" class="form-control"  id = 'patente' value="${auto.getID()}" size="7"  >
      			</c:if>
      			<c:if test ="${modo == 'edit'}"> 
      				Patente :<input type="text" class="form-control"  id = 'patenteEdit' value="${auto.getID()}" readonly  >
      			</c:if>
  				</div>
  			</div>
  			<c:if test ="${modo == 'new' or modo == 'edit'}"> 
  	  			<div class="col" align="left" >
  	  				<div class="col-sm-10">	
			     	Cliente :
			     		<select  id = "listaClientes" class="custom-select custom-select-lg mb-3">
						<c:if test ="${modo == 'new'}"> 
							<option selected value = "0" >Seleccionar cliente</option>
						</c:if>
						<c:if test ="${modo == 'edit'}"> 
							<option selected value = "${auto.getCliente().getID()}" >${auto.getCliente().getDni()}-${auto.getCliente().getApellido()}, ${auto.getCliente().getNombre()}</option>
						</c:if>
						<c:forEach items="${listaClientes}" var="usu">
							<option id = clienteIDLista value="${usu.getID()}">${usu.getDni()}-${usu.getApellido()}, ${usu.getNombre()}</option>
						</c:forEach>
						</select>

						
					</div>
				</div>
			</c:if>
  			
  	  	 </div>
  	  	 
  	  	 <!-- Campo Marca -->
  	  <div class="row">
  	  	 	<div class="col">
  	  			
  					<div class="col-sm-10">
  							Marca :<input type="text" class="form-control"  id = "marca" value="${auto.getMarca()}"  >
  					</div>
  	  		</div>		
  	  		<!-- Campo Modelo -->
  			
  	  		<div class="col">
  	  				<div class="col-sm-10">

  							Modelo :<input type="text" class="form-control" id = "modelo"  value="${auto.getModelo()}"  >
  					</div>	
  	  		</div>
  		 <!-- Campo Color -->
  			
  	  		<div class="col">
  	  				<div class="col-sm-10">	
  							Color :<input type="text" class="form-control" id = "color"  value="${auto.getColor()}"  >  						
  					</div>	
  	  		</div>

		</div>
		

		
			<div align="center">
				<button type = "button" id = "btnConfirmar" onclick="valida();" class="btn btn-primary">Confirmar</button>
				<a href="menu?page=listaautomoviles"><button type="button" class="btn btn-secondary">Volver</button></a>
			</div>
			
	</form>
	


<script type = "text/javascript">
function valida()
{  var modo = document.getElementById("modo").value
	var patente;
	y = true;
	if(document.getElementById("listaClientes") != null )
	{if(document.getElementById("listaClientes").value == '0'){
   		alert("Debe seleccionar un cliente");
   	 	y = false;
	}
	}
	if(modo == 'new'){
	if(document.getElementById("patente").value == 0)
	{
   		alert("Debe ingresar una patente");
   	 	y = false;
	}
	else{patente = document.getElementById("patente").value }
		}
	if(modo == 'edit'){
		if(document.getElementById("patenteEdit").value == 0)
		{
	   		alert("Debe ingresar una patente");
	   	 	y = false;
		}else{patente = document.getElementById("patenteEdit").value}}
	

	if(y == true)
		{
		 doPost(patente);
		}
}


function doPost(patente)
{
    $.post("automovil", {
        patente		  : patente,
        listaClientes : document.getElementById("listaClientes").value,
        color	      : document.getElementById("color") != null  ? document.getElementById("color").value : "" ,
        modelo	      : document.getElementById("modelo") != null ? document.getElementById("modelo").value : "",
        marca		  : document.getElementById("marca") != null ? document.getElementById("marca").value : "" ,
        modo		  : document.getElementById("modo").value
   			}).done(function (responseText) {
            if (responseText.trim() != '') { 
            	 window.location.reload();
            	 alert(responseText ); 
           }else
        	   {
        	   window.location.replace("menu?page=listaautomoviles");
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