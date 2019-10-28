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
<title>Insert title here</title>
<link href="style/css/tabla.css" rel="stylesheet">
<%List<Factura> x = (ArrayList<Factura>)request.getAttribute("listaFacturas");%>
</head>

<body>

 <%=x %>>
 <%for(Factura f : x){%>
<tr><td> <%=f.getImporteTotal() %></td></tr>
 <%} %>
 

	


</body>
</html>