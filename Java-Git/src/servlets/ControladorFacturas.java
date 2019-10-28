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
@WebServlet("/ControladorFacturas")
public class ControladorFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorFacturas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		
		DataFactura df = new DataFactura();
		

		//DataUsuario du = new DataUsuario();
		//Usuario usu = du.getOnePorEmail("admin@hotmail.com");
		request.setAttribute("listaFacturas",df.GetAll());
		RequestDispatcher miDispatcher = request.getRequestDispatcher("listafacturas.jsp"); 
		miDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
