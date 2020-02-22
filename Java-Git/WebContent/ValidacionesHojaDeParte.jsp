<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page import="business.*" %>	
 <%@ page import="entities.*" %>
 <%@ page import="java.util.ArrayList" %>
<%BusinessHojaDeParte negocioHojaDeParte = new BusinessHojaDeParte();
 BusinessHojaRepuesto negocioHojaRepuesto = new BusinessHojaRepuesto();
 ArrayList<HojaRepuesto> hojarepuestos = negocioHojaRepuesto.getAll(Integer.parseInt(request.getParameter("idHoja")));
   
 /*Validar que no tenga repuestos asociados */
   if (hojarepuestos.size() != 0) 
    {
        out.print("La hoja de parte tiene repuestos asociados");
    } else{ out.print("La hoja de parte tiene repuestos asociados");} %>
