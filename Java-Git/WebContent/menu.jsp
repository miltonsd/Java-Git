<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="style/css/menu.css" rel="stylesheet">
<script type="text/javascript" src="style/js/menu.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Menu</h1>

<form action= "ControladorMenu" method= "POST">
<nav class="nav">
	<ul>
		<li><a href="index.jsp">Usuarios</a>
        <li><a href="#">Clientes</a>
		<li><a href="#">Vehiculos</a>
		<li><a href="#">Respuestos</a>
		<li><a href="#">Facturacion</a>
		<li><a href="#">Hoja de parte</a>
		<li><a href="index.jsp" type="submit"  id="clickSalir"  >Salir</a>
	</ul>
</nav>
</form>
<footer>
    <p class="main">
        TP Java 2019 Milton, Sotto Diaz - Alejandro Donnola
    </p>
</footer>
</body>
</html>