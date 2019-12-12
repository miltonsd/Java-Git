package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessFactura;
import business.BusinessProveedor;
import business.BusinessRepuesto;
import business.BusinessTipoRepuesto;
import entities.Repuesto;


/**
 * Servlet implementation class ControladorMenu
 */
@WebServlet({ "/menu/*", "/MENU/*"})
public class ControladorMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
	private BusinessFactura negocioFactura;   
	private BusinessTipoRepuesto negocioTipoRepuesto; 
	private BusinessProveedor negocioProveedor; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorMenu() {
        super();
        negocioRepuesto = new BusinessRepuesto();
        negocioTipoRepuesto = new BusinessTipoRepuesto();
        negocioProveedor 	= new BusinessProveedor();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("page") == null) 
		{
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}
		else {
		switch(request.getParameter("page"))
		{
		case "listarepuestos":	
			ArrayList<Repuesto> listarep = new ArrayList<Repuesto>();
			for( Repuesto r : negocioRepuesto.getAll())
			{
				r.setProveedor(negocioProveedor.getOne((int)r.getProveedor().getID()));
				r.setTipoRepuesto(negocioTipoRepuesto.getOne((int)r.getTipoRepuesto().getID()));
				listarep.add(r);
			}
			request.setAttribute("listaRepuestos", listarep);
			request.getRequestDispatcher("RepuestoManagement.jsp").forward(request, response);
			break;
		case "listafacturas":
			request.setAttribute("listaFacturass", negocioFactura.getAll());
			request.getRequestDispatcher("RepuestoManagement.jsp").forward(request, response);
			break;
		}
		}
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
		doGet(request, response);
			
		
		}
		
	}

}
