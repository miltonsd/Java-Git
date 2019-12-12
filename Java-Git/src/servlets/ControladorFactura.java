package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

/**
 * Servlet implementation class ControladorFactura
 */
@WebServlet({"/Factura/*","/factura/*","/FACTURA/*"})
public class ControladorFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataFactura datosFactura ;
    private DataUsuario	datosUsuario ; 
    private String action;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorFactura() {
        super();
        datosFactura = new DataFactura();
        datosUsuario = new DataUsuario();
        String action ="" ;
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Factura factura = new Factura();
		factura.setID(Integer.parseInt(request.getParameter("id")));
		switch (request.getPathInfo()) {
		case "/edit":
			action="edit";
			request.setAttribute("listaUsuarios", datosUsuario.GetAll());
			forwardToFacturaCrud(datosFactura.GetOne((int)factura.getID()),action, request, response);
		case "/display":
			action="display";
			forwardToFacturaCrud(datosFactura.GetOne((int)factura.getID()),action, request, response);
			break;
		case "/emitir":
			action="emitir";
			forwardToFacturaCrud(datosFactura.GetOne((int)factura.getID()),action, request, response);
			break;
		case "/new":
			action="new";
			request.setAttribute("listaUsuarios", datosUsuario.GetAll());
			forwardToFacturaCrud(datosFactura.GetOne((int)factura.getID()),action, request, response);
			break;

		case "/delete":
			try {
				
			datosFactura.Delete((int) factura.getID());
			}
			finally {response.sendRedirect("/listafacturas");}
			break;
		default:
			//redirigir a página de error
			break;
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Factura factura = new Factura();
		Usuario usuario = new Usuario();
		factura.setID(Integer.parseInt(request.getParameter("idFactura")));
		System.out.println(request.getParameter("idFactura"));
		switch (request.getParameter("modo")) {
		case "edit":	
			System.out.println(request.getParameter("usuarioIdLista"));
			usuario.setID(2);
			factura.setUsuario(usuario);
			factura.setFecha_emision(null);
			datosFactura.Update(factura);
			response.sendRedirect("/listafacturas");
		case "new":
			usuario.setID(request.getParameter("usuarioIdLista"));
			factura.setUsuario(usuario);
			factura.setFecha_emision(null);
			datosFactura.Insert(factura);
		case "emitir":
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			factura.setFecha_emision(sqlDate);
			datosFactura.Update(factura);
			response.sendRedirect("/listafacturas");
		case "display":
			response.sendRedirect("Java-Git/listafacturas");
		default:
			//redirigir a página de error
			break;
		}	
		
		
		
		
		
	}
	protected void forwardToFacturaCrud(Factura fac, String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("factura", fac);
		request.setAttribute("modo", action);
		request.getRequestDispatcher("/factura.jsp").forward(request, response);
		
	}

}
