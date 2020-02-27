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
    <title>Taller Mec�nico - Hojas de Parte</title>
    <link rel="shortcut icon" href="style/img/logo.png">
		<link href="style/css/tabla.css" rel="stylesheet">
		<link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
		<script src="style/js/jquery-3.4.1.min.js">  </script>
		<script type="text/javascript">
    	function borrarHDP(x) {
        var id = "#btnEliminar" + x;
        $.post("listadohojasdeparte", {
        	idhoja: x,
          modo: "delete",
          idfactura: ${ idf }
       		}).done(function (responseText) {
       			if (responseText.trim() != '') { alert(responseText); }
            else { alert('Hoja de parte eliminada'); }
            }).fail(function (data, textStatus, xhr) {
            	//This shows status code eg. 403
              console.log("error", data.status);
              //This shows status message eg. Forbidden
              console.log("STATUS: " + xhr);
              }).always(function () {
            	  window.location.reload();
            	  });
    	}
		</script>
	</head>
	<body>
    <h1 style="text-align: center;">Listado de Hojas de Parte</h1>
	  <form action="listadohojasdeparte" name="form" method="GET">
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Nro</th>
            <th scope="col">Costo mano de obra</th>
            <th scope="col">Mec�nico</th>
            <th scope="col">Nro Factura</th>
            <th scope="col">Patente </th>
            <th scope="col">Detalle </th>
            <th scope="col">Operaciones</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listaHojaDeParte}" var="h" varStatus="count">
	  				<input id="idHoja" name="idHoja" type="hidden" value="${h.getID()}">
            <input id="costoManoDeObra" name="costoManoDeObra" type="hidden" value="${h.getCostoManoDeObra()}">
            <input id="idMecanico" name="idMecanico" type="hidden" value="${h.getMecanico().getID()}">
            <input name="idFactura" id="idFactura" type="hidden" value="${h.getFactura().getID()}">
            <input name="idAuto" id="idAuto" type="hidden" value="${h.getAutomovil().getID()}">
					  <tr id='tabla'>
              <th scope="row"><c:out value="${count.index + 1}"/><br></th>
              <td><c:out value="${h.getCostoManoDeObra()}"/><br></td>
              <td><c:out value="${h.getMecanico()}"/><br></td>
              <td><c:out value="${h.getFactura().getID()}"/><br></td>
              <td><c:out value="${h.getAutomovil().getID()}"/><br></td>
              <td><c:out value="${h.getDetalle()}"/><br></td>
							<td>
								<a href="menu?page=listahojasrepuestos&idhoja=${h.getID()}"><button type="Button"
                   class="btn btn-info">Repuestos</button></a>
								<c:if test="${idf != null && emitido == false}">
                  <a href="listadohojasdeparte?idhoja=${h.getID()}&idfactura=${idf}&modo=edit"><button
                     type="Button" class="btn btn-info">Editar</button></a>
                  <button id="btnEliminar${h.getID()}" value="${h.getID()}" type="Button"
                          onclick="borrarHDP('${h.getID()}');" class="btn btn-danger">Baja</button>
                </c:if>
                <c:if test="${idf == null}">
                  <a href="listadohojasdeparte?idhoja=${h.getID()}&modo=edit"><button type="Button"
                     class="btn btn-info">Editar</button></a>
                  <a href="listadohojasdeparte?idhoja=${h.getID()}&modo=delete"><button id="btnElimina"
                     type="Button" class="btn btn-danger" name="btnEliminar1">Baja</button></a>
                </c:if>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <c:if test="${idf != null}">
        <a href='menu?page=listafacturas'><button type="Button" class="btn btn-primary">Volver</button></a>
      </c:if>
      <c:if test="${idf == null}">
        <a href='menu'><button type="Button" class="btn btn-primary">Volver</button></a>
      </c:if>
      <c:if test="${emitido == false}">
        <a href="listadohojasdeparte?modo=new&idfactura=${idf}"><button type="Button"
           class="btn btn-secondary">Agregar hoja</button></a>
      </c:if>
    </form>
	</body>
</html>