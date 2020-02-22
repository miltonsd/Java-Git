package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessAutomovil;
import business.BusinessUsuario;
import entities.Automovil;
import entities.Usuario;

/**
 * Servlet implementation class AutomovilCrud
 */
@WebServlet("/automovil/*")
public class AutomovilCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessAutomovil negocioAutomovil;
	private BusinessUsuario negocioUsuario;
	private String Mensaje = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutomovilCrud() {
		super();
		negocioAutomovil = new BusinessAutomovil();
		negocioUsuario = new BusinessUsuario();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Automovil auto = new Automovil();
		auto.setCliente(new Usuario());
		PrintWriter out = response.getWriter();
		String modo = request.getParameter("modo");
		Mensaje = null;

		switch (modo) {
		case "edit":
			auto = negocioAutomovil.getOne(request.getParameter("patente"));
			auto.getCliente().setID(Integer.parseInt(request.getParameter("listaClientes")));
			auto.setColor(request.getParameter("color"));
			auto.setMarca(request.getParameter("marca"));
			auto.setModelo(request.getParameter("modelo"));

			if (Validaciones(auto, request, response, "edit")) {
				negocioAutomovil.Edit(auto);

			} else {
				out.print(Mensaje);
			}

			break;
		case "new":
			auto.setID(request.getParameter("patente"));
			auto.getCliente().setID(Integer.parseInt(request.getParameter("listaClientes")));
			auto.setColor(request.getParameter("color"));
			auto.setMarca(request.getParameter("marca"));
			auto.setModelo(request.getParameter("modelo"));

			if (Validaciones(auto, request, response, "new")) {
				negocioAutomovil.New(auto);

			} else {
				out.print(Mensaje);
			}

			break;
		default:
			request.getRequestDispatcher("error404.html").forward(request, response);
			break;
		}

	}

	protected boolean Validaciones(Automovil auto, HttpServletRequest request, HttpServletResponse response,
			String modo) throws ServletException, IOException {

		if (Mensaje != null) {
			return false;
		} else {
			return true;
		}

	}

}
