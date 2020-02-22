package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessFactura;
import business.BusinessHojaDeParte;
import business.BusinessProveedor;
import business.BusinessRepuesto;
import business.BusinessTipoRepuesto;
import business.BusinessUsuario;
import business.CalculoDeImporte;
import entities.Automovil;
import entities.Factura;
import entities.HojaDeParte;
import entities.Usuario;

/**
 * Servlet implementation class HojaDeParteCrud
 */
@WebServlet("/hojadeparte")
public class HojaDeParteCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
	private BusinessTipoRepuesto negocioTipoRepuesto;
	private BusinessProveedor negocioProveedor;
	private BusinessFactura negocioFactura;
	private BusinessHojaDeParte negocioHojaDeParte;
	private BusinessUsuario negocioUsuario;

	public HojaDeParteCrud() {
		super();
		negocioRepuesto = new BusinessRepuesto();
		negocioTipoRepuesto = new BusinessTipoRepuesto();
		negocioProveedor = new BusinessProveedor();
		negocioFactura = new BusinessFactura();
		negocioHojaDeParte = new BusinessHojaDeParte();
		negocioUsuario = new BusinessUsuario();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HojaDeParte hojadeparte = new HojaDeParte();
		CalculoDeImporte cdi = new CalculoDeImporte();
		hojadeparte.setFactura(new Factura());
		hojadeparte.setMecanico(new Usuario());
		hojadeparte.setAutomovil(new Automovil());
		hojadeparte.getFactura().setID(Integer.parseInt(request.getParameter("idFactura")));
		hojadeparte.setCostoManoDeObra(Float.parseFloat(request.getParameter("costoManoDeObra")));
		hojadeparte.getAutomovil().setID((String) request.getParameter("patenteLista"));
		hojadeparte.getMecanico().setID(Integer.parseInt(request.getParameter("usuariosLista")));
		hojadeparte.setDetalle(request.getParameter("detalle"));

		switch (request.getParameter("modo")) {

		case "edit":
			hojadeparte.setID(Integer.parseInt(request.getParameter("idHoja")));
			negocioHojaDeParte.Edit(hojadeparte);
			cdi.Calcular((int) hojadeparte.getFactura().getID());
			response.sendRedirect(
					"menu?page=listahojasdeparte&idfactura=" + hojadeparte.getFactura().getID().toString());
			break;
		case "new":
			negocioHojaDeParte.New(hojadeparte);
			cdi.Calcular((int) hojadeparte.getFactura().getID());
			response.sendRedirect(
					"menu?page=listahojasdeparte&idfactura=" + hojadeparte.getFactura().getID().toString());
			break;

		default:
			request.getRequestDispatcher("error404.html").forward(request, response);
		}
	}

}
