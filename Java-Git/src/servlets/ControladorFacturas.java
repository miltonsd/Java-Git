package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataFactura;
import data.DataUsuario;
import entities.Factura;
import entities.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ControladorFacturas
 */
@WebServlet({ "/listadofacturas/*", "/listafacturas/*", "/LISTAFACTURAS/*", "/lista-facturas/*", "/ListadoFacturas/*" })
public class ControladorFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataFactura datosFactura;
	private DataUsuario datosUsuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorFacturas() {
        super();
        datosFactura = new DataFactura();
        datosUsuario = new DataUsuario();
    	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
		request.setAttribute("listaFacturas",datosFactura.GetAll());
		RequestDispatcher miDispatcher = request.getRequestDispatcher("listafacturas.jsp"); 
		request.getRequestDispatcher("listafacturas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("factura", datosFactura.GetOne( Integer.parseInt(request.getParameter("idFactura"))));
		RequestDispatcher miDispatcher = request.getRequestDispatcher("factura.jsp"); 
		if(request.getParameter("idFactura")!=null)
		{switch(request.getParameter("modo")) 
		{
		case "display" :
				request.setAttribute("modo", "display");
				response.sendRedirect(request.getContextPath()+"/factura/display");
		
		case "edit":	
				request.setAttribute("modo", "edit");
				request.setAttribute("listaUsuarios", datosUsuario.GetAll());
				response.sendRedirect(request.getContextPath()+"/factura/edit");
		case "delete":	
				request.setAttribute("modo", "delete");
				response.sendRedirect(request.getContextPath()+"/factura/edit");
		case "new":	
				request.setAttribute("modo", "new");
				request.getRequestDispatcher("factura.jsp").forward(request, response);	
		default:
			System.out.println("redirigir a página de error");
			break;
		}
		}
		
		
	}

}
