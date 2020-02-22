package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import entities.Usuario;

/**
 * Servlet implementation class ControladorFacturas
 */
@WebServlet({ "/listadofacturas/*", "/listafacturas/*", "/LISTAFACTURAS/*", "/lista-facturas/*", "/ListadoFacturas/*" })
public class FacturaManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
	private BusinessTipoRepuesto negocioTipoRepuesto;
	private BusinessProveedor negocioProveedor;
	private BusinessFactura negocioFactura;
	private BusinessHojaDeParte negocioHojaDeParte;
	private BusinessHojaRepuesto negocioHojaRepuesto;
	private BusinessUsuario negocioUsuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacturaManagement() {
		super();
		negocioRepuesto = new BusinessRepuesto();
		negocioTipoRepuesto = new BusinessTipoRepuesto();
		negocioProveedor = new BusinessProveedor();
		negocioFactura = new BusinessFactura();
		negocioHojaDeParte = new BusinessHojaDeParte();
		negocioUsuario = new BusinessUsuario();
		negocioHojaRepuesto = new BusinessHojaRepuesto();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Factura factura = new Factura();
		PrintWriter out = response.getWriter();
		String modo = request.getParameter("modo");
		ArrayList<Usuario> listaClientes = new ArrayList<Usuario>();

		for (Usuario u : negocioUsuario.getAll()) {
			if ((int) u.getRol().getID() == 2) {
				listaClientes.add(u);
			}

		}
		if (modo != "new" && (request.getParameter("id") != null)) {
			factura = negocioFactura.getOne((int) Integer.parseInt(request.getParameter("id")));
		}
		switch (modo) {
		case "edit":
			request.setAttribute("factura", negocioFactura.getOne((int) factura.getID()));
			request.setAttribute("idf", factura.getID());
			request.setAttribute("usuario", negocioUsuario.getOne((int) factura.getUsuario().getID()));
			request.setAttribute("listaUsuarios", listaClientes);
			request.setAttribute("listaHojaDeParte", negocioHojaDeParte.getAll());
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("FacturaCrud.jsp").forward(request, response);
			break;

		case "emitir":
			Date d1 = new Date();
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
			String formattedDate = df.format(d1);
			request.setAttribute("factura", negocioFactura.getOne((int) factura.getID()));
			request.setAttribute("usuario", negocioUsuario.getOne((int) factura.getUsuario().getID()));
			request.setAttribute("datetoday", formattedDate);
			request.setAttribute("idf", factura.getID());
			request.setAttribute("modo", modo);

			request.getRequestDispatcher("FacturaCrud.jsp").forward(request, response);
			break;

		case "new":
			ArrayList<Factura> listafactura = negocioFactura.getAll();
			int i;
			if (listafactura.size() != 0) {
				i = (int) listafactura.get(listafactura.size() - 1).getID();
			} else {
				i = 1;
			}
			request.setAttribute("listaUsuarios", listaClientes);
			request.setAttribute("idf", i + 1);
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("FacturaCrud.jsp").forward(request, response);
			break;

		case "report":
			ArrayList<HojaDeParte> hojasdeparte = negocioHojaDeParte
					.getAllConFactura(((int) Integer.parseInt(request.getParameter("id"))));
			for (HojaDeParte hp : hojasdeparte) {
				hp.setHojasRepuestos(negocioHojaRepuesto.getAll((int) hp.getID()));
				hp.setMecanico(negocioUsuario.getOne((int) hp.getMecanico().getID()));
				for (HojaRepuesto hr : hp.getHojaRepuestos()) {
					hr.setRepuesto(negocioRepuesto.getOne((int) hr.getRepuesto().getID()));
				}
			}
			factura.setUsuario(negocioUsuario.getOne((int) factura.getUsuario().getID()));
			request.setAttribute("listaHojasDeParte", hojasdeparte);
			request.setAttribute("factura", factura);
			request.getRequestDispatcher("FacturaReporte.jsp").forward(request, response);
			break;

		case "delete":
			try {
				negocioFactura.Delete(factura);
			} catch (Exception e) {
				System.out.println(e.getMessage());

			} finally {
				response.sendRedirect("menu?page=listafacturas");
			}

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

	}

}
