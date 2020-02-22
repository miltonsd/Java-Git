package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessAutomovil;
import business.BusinessHojaDeParte;
import business.BusinessUsuario;
import entities.Automovil;
import entities.HojaDeParte;
import entities.Usuario;

/**
 * Servlet implementation class AutomovilManagement
 */
@WebServlet("/listaautomoviles/*")
public class AutomovilManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessAutomovil negocioAutomovil;
	private BusinessUsuario negocioUsuario;
	private BusinessHojaDeParte negocioHojaDeParte;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutomovilManagement() {
		super();
		negocioAutomovil = new BusinessAutomovil();
		negocioUsuario = new BusinessUsuario();
		negocioHojaDeParte = new BusinessHojaDeParte();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Automovil auto = new Automovil();

		ArrayList<Usuario> listaClientes = new ArrayList<Usuario>();
		request.setAttribute("modo", request.getParameter("modo"));
		if (request.getParameter("patente") != null) {
			auto = negocioAutomovil.getOne(request.getParameter("patente"));
		}

		for (Usuario u : negocioUsuario.getAll()) {
			if ((int) u.getRol().getID() == 2) {
				listaClientes.add(u);
			}

		}

		switch (request.getParameter("modo")) {
		case "edit":
			auto.setCliente(negocioUsuario.getOne((int) auto.getCliente().getID()));
			request.setAttribute("listaClientes", listaClientes);
			request.setAttribute("auto", auto);
			request.getRequestDispatcher("AutomovilCrud.jsp").forward(request, response);

			break;
		case "new":
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("AutomovilCrud.jsp").forward(request, response);
			break;

		default:
			request.getRequestDispatcher("error404.html").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out = response.getWriter();
		String modo = request.getParameter("modo");

		Automovil auto = new Automovil();
		if (modo != "new" && request.getParameter("patente") != null) {
			auto = negocioAutomovil.getOne(request.getParameter("patente"));
		}
		if (Validaciones(auto, request, response)) {

			negocioAutomovil.Delete(auto);
		}

	}

	protected boolean Validaciones(Automovil auto, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<HojaDeParte> hojasdeparte = new ArrayList<HojaDeParte>();
		PrintWriter out = response.getWriter();
		String Mensaje = null;

		for (HojaDeParte h : negocioHojaDeParte.getAll()) {
			if (((String) h.getAutomovil().getID()).equals((String) auto.getID())) {
				hojasdeparte.add(h);
			}
		}
		if (Mensaje == null && hojasdeparte.size() != 0) {
			Mensaje = "El vehiculo esta siendo utilizado en una factura";
		}

		if (Mensaje != null) {
			out.print(Mensaje);
			return false;
		} else {
			return true;
		}

	}
}
