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
import entities.Factura;
import entities.Usuario;

/**
 * Servlet implementation class FacturaCrud
 */
@WebServlet("/factura/*")
public class FacturaCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
	private BusinessTipoRepuesto negocioTipoRepuesto;
	private BusinessProveedor negocioProveedor;
	private BusinessFactura negocioFactura;
	private BusinessHojaDeParte negocioHojaDeParte;
	private BusinessUsuario negocioUsuario;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacturaCrud() {
		super();
		negocioRepuesto = new BusinessRepuesto();
		negocioTipoRepuesto = new BusinessTipoRepuesto();
		negocioProveedor = new BusinessProveedor();
		negocioFactura = new BusinessFactura();
		negocioHojaDeParte = new BusinessHojaDeParte();
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		factura.setUsuario(new Usuario());

		switch (request.getParameter("modo")) {
		case "edit":
			factura.setID(Integer.parseInt(request.getParameter("idFactura")));
			factura.getUsuario().setID(Integer.parseInt(request.getParameter("usuariosLista")));
			factura.setImporteTotal(Float.parseFloat(request.getParameter("importeTotal")));
			negocioFactura.Edit(factura);
			response.sendRedirect("menu?page=listafacturas");
			break;
		case "new":
			factura.setID(Integer.parseInt(request.getParameter("idFactura")));
			factura.getUsuario().setID(Integer.parseInt(request.getParameter("usuariosLista")));
			factura.setImporteTotal(0);
			negocioFactura.New(factura);
			response.sendRedirect("menu?page=listafacturas");
			break;
		case "emitir":
			factura = negocioFactura.getOne(Integer.parseInt(request.getParameter("idFactura")));
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			factura.setFecha_emision(date);
			negocioFactura.Edit(factura);
			response.sendRedirect("menu?page=listafacturas");
			break;
		default:
			request.getRequestDispatcher("error404.html").forward(request, response);
		}
	}

}
