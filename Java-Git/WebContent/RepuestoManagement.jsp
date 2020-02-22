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
    <script>
        function tipoRepuestoLista() {
            var x = document.getElementById("tipoRepuestoLista").value;
            window.location.href = "/Java-Git/menu?page=listarepuestos&tiporepuesto=" + x;

        }

    </script>
</head>

<body>


    <div class="col-sm-10">

        Tipo repuesto :<select name="tipoRepuestoLista" onchange="tipoRepuestoLista()" id="tipoRepuestoLista"
            class="custom-select custom-select-lg mb-3">
            <c:if test='${tre == null || tre.getID() == 0}'>
                <option selected value="0">*Todos</option>
            </c:if>
            <c:if test='${tre != null && tre.getID() != 0}'>
                <option selected value="${tre.getID()}">${tre.getID()} - ${tre.getDescripcion()}</option>
                <c:if test='${tre.getID() != 0}'>
                    <option value="0">*Todos</option>
                </c:if>
            </c:if>

            <c:forEach items="${listaTipoRepuesto}" var="tr">
                <option id="tipoRepuestoListaSelec" value="${tr.getID()}">${tr.getID()} - ${tr.getDescripcion()}
                </option>
            </c:forEach>
        </select>
    </div>

    <h1 style="text-align: center;">Listado de Repuestos</h1>

    <form action="listadorepuestos" method="GET">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Precio Unitario</th>
                    <th scope="col">Stock</th>
                    <th scope="col">Tipo de repuesto</th>
                    <th scope="col">Proveedor</th>
                    <th scope="col">Opciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaRepuestos}" var="r">
                    <tr>
                        <input id="idRepuesto" name="idRepuesto" type="hidden" value="${r.getID()}">
                        <input id="repuestoDescripcion" name="repuestoDescripcion" type="hidden"
                            value="${r.getDescripcion()}">
                        <input id="precioUnitario" name="precioUnitario" type="hidden" value="${r.getPrecioUnitario()}">
                        <input name="stock" id="stock" type="hidden" value="${r.getStock()}">
                        <input name="tipoRepuesto" id="tipoRepuesto" type="hidden" value="${r.getTipoRepuesto()}">
                        <input name="proveedor" id="proveedor" type="hidden" value="${r.getProveedor().getID()}">

                        <th scope="row">
                            <c:out value="${r.getID()}" />
                            <p>
                        </th>
                        <td>
                            <c:out value="${r.getDescripcion()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${r.getPrecioUnitario()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${r.getStock()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${r.getTipoRepuesto().getDescripcion()}" />
                            <p>
                        </td>
                        <td>
                            <c:out value="${r.getProveedor().getID()}" />
                            <p>
                        </td>
                        <td>

                            <a href="listadorepuestos?id=${r.getID()}&modo=edit"><button type="Button"
                                    class="btn btn-info">Editar</button></a>
                            <a href="listadorepuestos?id=${r.getID()}&modo=delete"><button type="Button"
                                    class="btn btn-danger">Baja</button></a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <a href='menu'><button type="Button" class="btn btn-primary">Volver</button></a>
        <a href="listadorepuestos?&modo=new"><button type="Button" class="btn btn-secondary">Agregar Repuesto</button></a>
    </form>


</body>

</html>