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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">
    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="style/css/bootstrap.css">
    <link href="style/css" type="text/css" rel="stylesheet">
    <title>Factura</title>
    <script type="text/javascript">
        function valida() {
            var costoManoDeObra = document.getElementById("costoManoDeObra");
            var mecanico = document.getElementById("usuariosLista");
            var vehiculo = document.getElementById("patenteLista");
            var detalle  = document.getElementById("detalle");
            
         
            
            if (costoManoDeObra.value == 0) {
                alert("El costo de mano de obra es obligatorio");
                return false;
            }
            if (usuariosLista.value == 0) {
                alert("Debe seleccionar un mecanico");
                return false;
            }
            if (vehiculo.value == 0) {
                alert("Debe seleccionar una patente");
                return false;
            }
            if (!/^\d*\.?\d*$/.test(costoManoDeObra.value)) {
                alert("El valor del costo de mano de obra no es un número valido");
                return false;
            }
        }

    </script>
</head>

<body>

    <form action="hojadeparte" method="POST" onSubmit="return valida();">
        <input id="modo" name="modo" type="hidden" value="${modo}">
        <div class="row">
            <!-- Campo idFactura -->
            <div class="col">
                <div class="col-sm-10">
                    Factura nro :<input type="text" class="form-control" name="idFactura"
                        value="${modo=='edit' ?  hoja.getFactura().getID(): idf}" readonly>
                </div>
            </div>

            <!-- Campo idHoja -->
            <div class="col">
                <div class="col-sm-10">
                    Hoja nro :<input type="text" class="form-control" name="idHoja" value="${idh}" readonly>
                </div>
            </div>

            <!-- Campo CostoManoDeObra -->
            <div class="col">
                <c:if test="${modo == 'new' or modo == 'edit'}">
                    <div class="col-sm-10">
                        Costo mano de obra:<input type="text" class="form-control" id="costoManoDeObra"
                            name="costoManoDeObra" value="${hoja.getCostoManoDeObra()}">
                    </div>
                </c:if>
            </div>
        </div>

        <div class="row">
        
         <div class="col">
                <c:if test="${modo == 'new' or modo == 'edit'}">
                    <div class="col-sm-10">
                        Detalle:<input type="text" class="form-control" id="detalle"
                            name="detalle" value="${hoja.getDetalle()}">
                    </div>
                </c:if>
            </div>
            <c:if test="${modo == 'new' or modo == 'edit'}">
                <div class="col" align="left">
                    <div class="col-sm-10">
                        Mecanico :
                        <select required name="usuariosLista" class="custom-select custom-select-lg mb-3">
                            <c:if test="${modo == 'new'}">
                                <option selected value="">Seleccionar Mecanico</option>
                            </c:if>
                            <c:if test="${modo == 'edit'}">
                                <option selected value="${mecanico.getID()}">
                                    ${mecanico.getDni()}-${mecanico.getApellido()}, ${mecanico.getNombre()}</option>
                            </c:if>
                            <c:forEach items="${listaUsuarios}" var="usu">
                                <option id=usuarioIDLista value="${usu.getID()}">${usu.getDni()}-${usu.getApellido()},
                                    ${usu.getNombre()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </c:if>

            <!-- Campo Automovil -->
            <c:if test="${modo == 'new' or modo == 'edit'}">
                <div class="col" align="left">
                    <div class="col-sm-10">
                        Patente :

                        <select required name="patenteLista" class="custom-select custom-select-lg mb-3">
                            <c:if test="${modo == 'new'}">
                                <option selected value="">Seleccionar patente</option>
                            </c:if>
                            <c:if test="${modo == 'edit'}">
                                <option selected value="${hoja.getAutomovil().getID()}">${hoja.getAutomovil().getID()}
                                </option>
                            </c:if>
                            <c:forEach items="${listaAutomoviles}" var="auto">
                                <option id=automovilIDLista value="${auto.getID()}">${auto.getID()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </c:if>
        </div>


        <div align="center">
            <button type="Submit" name="btnConfirmar" id="btnConfirmar" value="${modo}"
                class="btn btn-primary">Confirmar</button>
            <c:if test="${hoja.getFactura().getID() != null && idf == null}">
                <a href="menu?page=listahojasdeparte&idfactura=${hoja.getFactura().getID()}"><button type="button"
                        class="btn btn-secondary">Volver</button></a>
            </c:if>
            <c:if test="${hoja.getFactura().getID() == null && idf !=null}">
                <a href="menu?page=listahojasdeparte&idfactura=${idf}"><button type="button"
                        class="btn btn-secondary">Volver</button></a>
            </c:if>
            <c:if test="${hoja.getFactura().getID() == null && idf == null}">
                <a href="menu?page=listahojasdeparte"><button type="button"
                        class="btn btn-secondary">Volver</button></a>
            </c:if>
        </div>

    </form>
</body>

</html>