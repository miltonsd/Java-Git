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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">
    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="style/css/bootstrap.css">
    <link href="style/css" type="text/css" rel="stylesheet">

</head>

<body>
    <h1 style="text-align: center;">Factruna nro ${factura.getID()}</h1>
    <form action="facturareporte">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Nro Factura</th>
                    <th scope="col">Fecha emisión</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">DNI</th>
                    <th scope="col">Importe total</th>
                </tr>
            </thead>
            <tbody>

                <tr>

                    <th scope="row">
                        <c:out value="${factura.getID()}" />
                        <p>
                    </th>
                    <td>
                        <c:out value="${factura.getFechaEmision() != null ? f.getFechaEmision() : 'Sin emitir'}" />
                        <p>
                    </td>
                    <td>
                        <c:out value="${factura.getUsuario()}" />
                        <p>
                    </td>
                    <td>
                        <c:out value="${factura.getUsuario().getDni()}" />
                        <p>
                    </td>
                    <td>
                        <c:out value="${factura.getImporteTotal()}" />
                        <p>
                    </td>
                    <td>
                </tr>

            </tbody>
        </table>


        <div style="padding-left:20px">

            <table class="table table-bordered"">
                <thead>
                    <tr>
                        <th scope="col">Nro Hoja</th>
                        <th scope="col">Mecanico</th>
                        <th scope="col">Vehiculo</th>
                        <th scope="col">Detalle</th>
                        <th scope="col">Mano de obra</th>
                    </tr>
                </thead>
<c:forEach items="${listaHojasDeParte}" var="hoja" varStatus="x">
                <tbody>
                    
                        <tr>

                            <th scope="row">
                                <c:out value="${x.index +1}" />
                                <p>
                            </th>
                            <td>
                                <c:out value="${hoja.getMecanico()}" />
                                <p>
                            </td>
                            <td>
                                <c:out value="${hoja.getAutomovil().getID()}" />
                                <p>
                            </td>
                            <td>
                                <c:out value="${hoja.getDetalle()}" />
                                <p>
                            </td>
                            <td>
                                <c:out value="${hoja.getCostoManoDeObra()}" />
                                <p>
                            </td>
                            
                           <td>
                            
                <div style="padding-left:20px;padding-top:20px">
                              <c:if test="${hoja.getHojaRepuestos().size() != 0}">
                              <table class="table table-bordered"">
                <thead>
                    <tr>
                        <th scope="col">Nro Repuesto</th>
                        <th scope="col">Descripcion</th>
                        <th scope="col">Precio unitario</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Total</th>
                    </tr>
                </thead>
                 <c:forEach items="${hoja.getHojaRepuestos()}" var="hr" varStatus="x">
   			  <tbody>
               
                	
                        <tr >
                            <th scope="row">
                                <c:out value="${x.index +1}" />
                                <p>
                            </th>

                            <td>
                                <c:out value="${hr.getRepuesto().getDescripcion()}" />
                                <p>
                            </td>
                            <td>
                                <c:out value="${hr.getRepuesto().getPrecioUnitario()}" />
                                <p>
                            </td>
                             <td>
                                <c:out value="${hr.getCantidad()}" />
                                <p>
                            </td>
                            <td>
                                <c:out value="${hr.getPrecioTotal()}" />
                                <p>
                            </td>
						
                        </tr>
 						
 						 </tbody>
						</c:forEach>
						
 						  </c:if>
 						   </table>
                            
                             </div>
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                        </tr>
                    
             
                   
          		
               </tbody>
             </c:forEach>
           </table>
      
        </div>

        


    </form>


</body>

</html>