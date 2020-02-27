<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Taller Mecanico - Menu</title>
    <link rel="shortcut icon" href="style/img/logo.png">
    <link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">    
    <link href="style/css/menu.css" rel="stylesheet">
		<script type="text/javascript" src="style/js/menu.js"></script>
  </head>
  <body>
		<h1>Menu</h1>
		<form action = "menu" name ="myForm" method = "GET">
	  	<nav class="nav">
				<ul>
		  		<li><a href="?page=listausers">Usuarios</a>
		  		<li><a href="?page=listaautomoviles">Vehiculos</a>
	 	  		<li><a href="?page=listarepuestos">Respuestos</a>
			  	<li><a href="?page=listafacturas">Facturacion</a>	
		   	  <li><a href="index.jsp">Salir</a>
		    </ul>
		  </nav>
	  </form>
		<footer>
    	<p class="main">
    		TP Java 2019 Milton Sotto Diaz - Alejandro Donnola
    	</p>
		</footer>
	</body>
</html>	