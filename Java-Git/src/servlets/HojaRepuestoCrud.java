package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessFactura;
import business.BusinessHojaDeParte;
import business.BusinessHojaRepuesto;
import business.BusinessRepuesto;
import business.CalculoDeImporte;
import business.VerificarStockRepuesto;
import entities.HojaDeParte;
import entities.HojaRepuesto;
import entities.Repuesto;

/**
 * Servlet implementation class HojaRepuestoCrud
 */
@WebServlet("/hojarepuesto/*")
public class HojaRepuestoCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessHojaRepuesto negocioHojaRepuesto;
	private BusinessHojaDeParte negocioHojaDeParte;
	private BusinessRepuesto negocioRepuesto;
	private BusinessFactura negocioFactura;
	int cantidadanterior = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HojaRepuestoCrud() {
		super();
		negocioHojaRepuesto = new BusinessHojaRepuesto();
		negocioHojaDeParte = new BusinessHojaDeParte();
		negocioRepuesto = new BusinessRepuesto();
		negocioFactura = new BusinessFactura();

		// TODO Auto-generated constructor stub
	}

	private String Mensaje = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CalculoDeImporte cdi = new CalculoDeImporte();
		HojaRepuesto hojarepuesto = new HojaRepuesto();
		HojaDeParte hojadeparte = negocioHojaDeParte.getOne(Integer.parseInt(request.getParameter("idHoja")));
		PrintWriter out = response.getWriter();
		hojarepuesto.setRepuesto(new Repuesto());
		hojarepuesto.setHojaDeParte(hojadeparte);
		Mensaje = null;

		switch (request.getParameter("modo")) {

		case "edit":

			hojarepuesto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			hojarepuesto.getRepuesto().setID(Integer.parseInt(request.getParameter("idRepuesto")));
			hojarepuesto.getHojaDeParte().setID(Integer.parseInt(request.getParameter("idHoja")));
			cantidadanterior = negocioHojaRepuesto
					.getOne((int) hojarepuesto.getHojaDeParte().getID(), (int) hojarepuesto.getRepuesto().getID())
					.getCantidad();
			hojarepuesto
					.setPrecioTotal(negocioRepuesto.getOne((int) hojarepuesto.getRepuesto().getID()).getPrecioUnitario()
							* hojarepuesto.getCantidad());
			if (Validaciones(hojarepuesto, request, response, "edit")) {
				negocioHojaRepuesto.Edit(hojarepuesto);
				this.ActualizarStock(hojarepuesto, request, response, "edit");
				cdi.Calcular((int) hojadeparte.getFactura().getID());
			} else {
				out.print(Mensaje);
			}

			break;

		case "new":
			hojarepuesto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			hojarepuesto.getRepuesto().setID(Integer.parseInt(request.getParameter("repuestosLista")));
			hojarepuesto.getHojaDeParte().setID(Integer.parseInt(request.getParameter("idHoja")));

			hojarepuesto
					.setPrecioTotal(negocioRepuesto.getOne((int) hojarepuesto.getRepuesto().getID()).getPrecioUnitario()
							* hojarepuesto.getCantidad());
			if (Validaciones(hojarepuesto, request, response, "new")) {
				negocioHojaRepuesto.New(hojarepuesto);
				this.ActualizarStock(hojarepuesto, request, response, "new");
				cdi.Calcular((int) hojadeparte.getFactura().getID());
			} else {
				out.print(Mensaje);
			}
			break;

		default:
			request.getRequestDispatcher("error404.html").forward(request, response);
		}
	}

	protected boolean Validaciones(HojaRepuesto hojarepuesto, HttpServletRequest request, HttpServletResponse response,
			String modo) throws ServletException, IOException {
		ArrayList<HojaRepuesto> hojarepuestos = new ArrayList<HojaRepuesto>();
		VerificarStockRepuesto vsr = new VerificarStockRepuesto(hojarepuesto.getRepuesto());

		if (Mensaje == null && hojarepuesto.getHojaDeParte().getID() == null) {
			Mensaje = "El parametro idhoja esta vacio";
		} else {
			hojarepuestos = negocioHojaRepuesto.getAll((int) hojarepuesto.getHojaDeParte().getID());
		}
		if (Mensaje == null && modo == "new") {

			for (HojaRepuesto hr : negocioHojaRepuesto.getAll((int) hojarepuesto.getHojaDeParte().getID())) {
				if ((int) hr.getRepuesto().getID() == (int) hojarepuesto.getRepuesto().getID()) {
					Mensaje = "El repuesto ya existe";
					break;

				}
			}

		}

		if (Mensaje == null && negocioFactura.getOne(
				(int) negocioHojaDeParte.getOne((int) hojarepuesto.getHojaDeParte().getID()).getFactura().getID())
				.getFechaEmision() != null) {
			Mensaje = "La factura ya fue emitida";
		}

		if (Mensaje == null) {
			Mensaje = vsr.ValidarStock(hojarepuesto.getCantidad(), cantidadanterior, modo);
		}

		if (Mensaje != null) {
			return false;
		} else {
			return true;
		}

	}

	protected void ActualizarStock(HojaRepuesto hojarepuesto, HttpServletRequest request, HttpServletResponse response,
			String modo) throws ServletException, IOException {
		VerificarStockRepuesto vsr = new VerificarStockRepuesto(hojarepuesto.getRepuesto());
		vsr.ActualizarStock(hojarepuesto.getCantidad(), cantidadanterior, modo);

	}

}
