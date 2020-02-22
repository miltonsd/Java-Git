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
import business.BusinessFactura;
import business.BusinessHojaDeParte;
import business.BusinessHojaRepuesto;
import business.BusinessProveedor;
import business.BusinessRepuesto;
import business.BusinessTipoRepuesto;
import business.BusinessUsuario;
import entities.Factura;
import entities.HojaDeParte;
import entities.HojaRepuesto;
import entities.Rol;

/**
 * Servlet implementation class HojaDeParteManagement
 */
@WebServlet("/listadohojasdeparte/*")
public class HojaDeParteManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
	private BusinessTipoRepuesto negocioTipoRepuesto;
	private BusinessProveedor negocioProveedor;
	private BusinessFactura negocioFactura;
	private BusinessHojaDeParte negocioHojaDeParte;
	private BusinessUsuario negocioUsuario;
	private BusinessAutomovil negocioAutomovil;
	BusinessHojaRepuesto negocioHojaRepuesto;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HojaDeParteManagement() {
		super();
		negocioRepuesto = new BusinessRepuesto();
		negocioTipoRepuesto = new BusinessTipoRepuesto();
		negocioProveedor = new BusinessProveedor();
		negocioFactura = new BusinessFactura();
		negocioHojaDeParte = new BusinessHojaDeParte();
		negocioUsuario = new BusinessUsuario();
		negocioAutomovil = new BusinessAutomovil();
		negocioHojaRepuesto = new BusinessHojaRepuesto();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HojaDeParte hoja = new HojaDeParte();
		PrintWriter out = response.getWriter();
		String modo = request.getParameter("modo");

		hoja.setFactura(new Factura());

		if (modo != "new" && (request.getParameter("idhoja") != null)) {
			hoja = negocioHojaDeParte.getOne((int) Integer.parseInt(request.getParameter("idhoja")));

		}
		if (request.getParameter("idfactura") != null) {

			hoja.setFactura(negocioFactura.getOne(Integer.parseInt(request.getParameter("idfactura"))));
		}
		switch (modo) {
		case "edit":
			request.setAttribute("hoja", negocioHojaDeParte.getOne((int) hoja.getID()));
			request.setAttribute("idh", hoja.getID());
			request.setAttribute("mecanico", negocioUsuario.getOne((int) hoja.getMecanico().getID()));
			request.setAttribute("listaUsuarios", negocioUsuario.getAllPorRol(Rol.Roles.Mecanico));
			request.setAttribute("listaAutomoviles",
					negocioAutomovil.getAllPorUsuario((int) hoja.getFactura().getUsuario().getID()));
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("HojaDeParteCrud.jsp").forward(request, response);
			break;

		case "new":
			ArrayList<HojaDeParte> hojas = negocioHojaDeParte.getAll();
			int i;
			if (hojas.size() != 0) {
				i = (int) hojas.get(hojas.size() - 1).getID();
			} else {
				i = 1;
			}
			request.setAttribute("idh", i + 1);
			request.setAttribute("idf", hoja.getFactura().getID());
			request.setAttribute("modo", modo);
			request.setAttribute("listaUsuarios", negocioUsuario.getAllPorRol(Rol.Roles.Mecanico));
			request.setAttribute("listaAutomoviles",
					negocioAutomovil.getAllPorUsuario((int) hoja.getFactura().getUsuario().getID()));
			request.getRequestDispatcher("HojaDeParteCrud.jsp").forward(request, response);
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
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out = response.getWriter();
		String modo = request.getParameter("modo");
		String Mensaje = null;
		HojaDeParte hoja = new HojaDeParte();
		hoja.setFactura(new Factura());
		if (request.getParameter("idfactura") != null) {
			hoja.getFactura().setID((Integer.parseInt(request.getParameter("idfactura"))));
		}
		if (modo != "new" && (request.getParameter("idhoja") != null)) {
			hoja = negocioHojaDeParte.getOne((int) Integer.parseInt(request.getParameter("idhoja")));
		}

		if (Validaciones(hoja, request, response)) {

			negocioHojaDeParte.Delete(hoja);
		}

	}

	protected boolean Validaciones(HojaDeParte hoja, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<HojaRepuesto> hojarepuestos = new ArrayList<HojaRepuesto>();
		PrintWriter out = response.getWriter();
		String Mensaje = null;

		if (Mensaje == null && request.getParameter("idhoja") == null) {
			Mensaje = "El parametro idhoja esta vacio";
		} else {
			hojarepuestos = negocioHojaRepuesto.getAll(Integer.parseInt(request.getParameter("idhoja")));
		}
		if (Mensaje == null && hojarepuestos.size() != 0) {
			Mensaje = "La hoja de parte tiene repuestos asociados";
		}
		if (Mensaje == null && negocioHojaDeParte.getOne(Integer.parseInt(request.getParameter("idhoja"))) == null) {
			Mensaje = "La hoja de parte no existe";

		}
		if (Mensaje == null && negocioFactura.getOne((int) (hoja.getFactura().getID())).getFechaEmision() != null) {
			Mensaje = "No se puede eliminar , la factura ya fue emitida";

		}
		if (Mensaje != null) {
			out.print(Mensaje);
			return false;
		} else {
			return true;
		}

	}

}
