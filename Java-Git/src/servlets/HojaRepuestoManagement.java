package servlets;

import java.io.IOException;

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
import business.CalculoDeImporte;
import business.VerificarStockRepuesto;
import entities.HojaRepuesto;
import entities.Repuesto;

/**
 * Servlet implementation class HojaRepuestoManagement
 */
@WebServlet("/listadohojasrepuestos")
public class HojaRepuestoManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
	private BusinessTipoRepuesto negocioTipoRepuesto;
	private BusinessProveedor negocioProveedor;
	private BusinessFactura negocioFactura;
	private BusinessHojaDeParte negocioHojaDeParte;
	private BusinessUsuario negocioUsuario;
	private BusinessAutomovil negocioAutomovil;
	private BusinessHojaRepuesto negocioHojaRepuesto;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HojaRepuestoManagement() {
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
		// TODO Auto-generated method stub
		String modo = request.getParameter("modo");
		CalculoDeImporte cdi = new CalculoDeImporte();
		HojaRepuesto hojarepuesto = new HojaRepuesto();

		if (request.getParameter("idrepuesto") != null) {
			hojarepuesto.setRepuesto(negocioRepuesto.getOne(Integer.parseInt(request.getParameter("idrepuesto"))));
		} else {
			hojarepuesto.setRepuesto(new Repuesto());
		}

		hojarepuesto.setHojaDeParte(negocioHojaDeParte.getOne(Integer.parseInt(request.getParameter("idhoja"))));
		int cantidadanterior = negocioHojaRepuesto
				.getOne((int) hojarepuesto.getHojaDeParte().getID(), (int) hojarepuesto.getRepuesto().getID())
				.getCantidad();

		switch (modo) {
		case "edit":

			request.setAttribute("hoja", negocioHojaDeParte.getOne((int) hojarepuesto.getHojaDeParte().getID()));
			request.setAttribute("repuesto", hojarepuesto.getRepuesto());
			request.setAttribute("hojarepuesto",
					negocioHojaRepuesto.getOne(Integer.parseInt(request.getParameter("idhoja")),
							Integer.parseInt(request.getParameter("idrepuesto"))));
			request.setAttribute("listaRepuestos", negocioRepuesto.getAll());
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("HojaRepuestoCrud.jsp").forward(request, response);
			break;

		case "new":
			request.setAttribute("hoja", negocioHojaDeParte.getOne((int) hojarepuesto.getHojaDeParte().getID()));
			request.setAttribute("listaRepuestos", negocioRepuesto.getAll());
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("HojaRepuestoCrud.jsp").forward(request, response);
			break;
		case "delete":
			negocioHojaRepuesto.Delete(hojarepuesto);
			response.sendRedirect("menu?page=listahojasrepuestos&idhoja=" + hojarepuesto.getHojaDeParte().getID());
			VerificarStockRepuesto vsr = new VerificarStockRepuesto(hojarepuesto.getRepuesto());

			vsr.ActualizarStock(0, cantidadanterior, "delete");

			cdi.Calcular((int) hojarepuesto.getHojaDeParte().getFactura().getID());
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
		doGet(request, response);
	}

}
