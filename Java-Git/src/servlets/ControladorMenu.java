package servlets;

import java.io.IOException;
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
import entities.Automovil;
import entities.Factura;
import entities.HojaDeParte;
import entities.HojaRepuesto;
import entities.Repuesto;
import entities.Usuario;

/**
 * Servlet implementation class ControladorMenu
 */
@WebServlet({ "/menu/*", "/MENU/*" })
public class ControladorMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
	private BusinessFactura negocioFactura;
	private BusinessTipoRepuesto negocioTipoRepuesto;
	private BusinessProveedor negocioProveedor;
	private BusinessUsuario negocioUsuario;
	private BusinessHojaDeParte negocioHojaDeParte;
	private BusinessHojaRepuesto negocioHojaRepuesto;
	private BusinessAutomovil negocioAutomovil;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorMenu() {
		super();
		negocioRepuesto = new BusinessRepuesto();
		negocioTipoRepuesto = new BusinessTipoRepuesto();
		negocioProveedor = new BusinessProveedor();
		negocioFactura = new BusinessFactura();
		negocioUsuario = new BusinessUsuario();
		negocioHojaDeParte = new BusinessHojaDeParte();
		negocioHojaRepuesto = new BusinessHojaRepuesto();
		negocioAutomovil = new BusinessAutomovil();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idFactura;
		int tipoDeRepuestoId = 0;

		if (request.getParameter("page") == null) {
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
			switch (request.getParameter("page")) {
			case "listarepuestos":
				ArrayList<Repuesto> listarep = new ArrayList<Repuesto>();
				request.setAttribute("listaTipoRepuesto", negocioTipoRepuesto.getAll());
				request.setAttribute("tr", null);
				if (request.getParameter("tiporepuesto") != null) {
					tipoDeRepuestoId = Integer.parseInt(request.getParameter("tiporepuesto"));
					request.setAttribute("tre", negocioTipoRepuesto.getOne(tipoDeRepuestoId));
				}

				if (tipoDeRepuestoId == 0) {
					for (Repuesto r : negocioRepuesto.getAll()) {
						r.setProveedor(negocioProveedor.getOne((int) r.getProveedor().getID()));
						r.setTipoRepuesto(negocioTipoRepuesto.getOne((int) r.getTipoRepuesto().getID()));
						listarep.add(r);
					}
					request.setAttribute("listaRepuestos", listarep);
					request.getRequestDispatcher("RepuestoManagement.jsp").forward(request, response);
					break;
				} else {
					for (Repuesto r : negocioRepuesto.getAll(tipoDeRepuestoId)) {
						r.setProveedor(negocioProveedor.getOne((int) r.getProveedor().getID()));
						r.setTipoRepuesto(negocioTipoRepuesto.getOne((int) r.getTipoRepuesto().getID()));
						listarep.add(r);
					}

					request.setAttribute("listaRepuestos", listarep);
					request.getRequestDispatcher("RepuestoManagement.jsp").forward(request, response);

				}

			case "listafacturas":
				ArrayList<Factura> listafact = new ArrayList<Factura>();
				for (Factura f : negocioFactura.getAll()) {
					f.setUsuario(negocioUsuario.getOne((int) f.getUsuario().getID()));
					listafact.add(f);
				}
				request.setAttribute("listaFacturas", listafact);
				request.getRequestDispatcher("FacturaManagement.jsp").forward(request, response);
				break;
			case "listahojasdeparte":
				ArrayList<HojaDeParte> listah = new ArrayList<HojaDeParte>();
				if (request.getParameter("idfactura") == null) {
					for (HojaDeParte h : negocioHojaDeParte.getAll()) {
						h.setMecanico(negocioUsuario.getOne((int) h.getMecanico().getID()));
						listah.add(h);
					}
					request.setAttribute("listaHojaDeParte", listah);
				} else {
					Factura factura = negocioFactura.getOne(Integer.parseInt(request.getParameter("idfactura")));

					request.setAttribute("emitido", factura.getFechaEmision() != null ? true : false);

					for (HojaDeParte h : negocioHojaDeParte
							.getAllConFactura(Integer.parseInt(request.getParameter("idfactura")))) {
						h.setMecanico(negocioUsuario.getOne((int) h.getMecanico().getID()));
						listah.add(h);
					}

					request.setAttribute("listaHojaDeParte", listah);
					request.setAttribute("idf", request.getParameter("idfactura"));
				}
				request.getRequestDispatcher("HojaDeParteManagement.jsp").forward(request, response);
				break;
			case "listahojasrepuestos":
				HojaDeParte hojadeparte = negocioHojaDeParte.getOne(Integer.parseInt(request.getParameter("idhoja")));
				ArrayList<HojaRepuesto> listahr = negocioHojaRepuesto
						.getAll(Integer.parseInt(request.getParameter("idhoja")));
				Factura factura = negocioFactura.getOne((int) hojadeparte.getFactura().getID());
				request.setAttribute("emitido", factura.getFechaEmision() != null ? true : false);

				for (HojaRepuesto hr : listahr) {
					hr.setRepuesto(negocioRepuesto.getOne((int) hr.getRepuesto().getID()));
					hr.setHojaDeParte(hojadeparte);
				}
				request.setAttribute("idf", factura.getID());
				request.setAttribute("idh", Integer.parseInt(request.getParameter("idhoja")));
				request.setAttribute("listaHojaRepuesto", listahr);
				request.getRequestDispatcher("HojaRepuestoManagement.jsp").forward(request, response);
				break;
			case "listaautomoviles":
				ArrayList<Automovil> automoviles = negocioAutomovil.getAll();
				for (Automovil a : automoviles) {
					a.setCliente(negocioUsuario.getOne((int) a.getCliente().getID()));
				}
				request.setAttribute("listaAutomoviles", automoviles);
				request.getRequestDispatcher("AutomovilManagement.jsp").forward(request, response);
				break;
			case "listausers":
				ArrayList<Usuario> usuarios = negocioUsuario.getAll();
				request.setAttribute("listaUsers", usuarios);
				request.getRequestDispatcher("UsuarioManagement.jsp").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("error404.html").forward(request, response);

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			doGet(request, response);

		}

	}

}
