package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.BusinessFactura;
import business.BusinessHojaDeParte;
import business.BusinessProveedor;
import business.BusinessRepuesto;
import business.BusinessTipoRepuesto;
import business.BusinessUsuario;
import data.DataFactura;
import data.DataUsuario;
import entities.Factura;
import entities.Repuesto;
import entities.Usuario;

import java.util.ArrayList;
import java.util.List;

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
    private BusinessUsuario negocioUsuario; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaManagement() {
        super();
        negocioRepuesto 	= new BusinessRepuesto();
        negocioTipoRepuesto = new BusinessTipoRepuesto();
        negocioProveedor 	= new BusinessProveedor();
        negocioFactura		= new BusinessFactura();
        negocioHojaDeParte	= new BusinessHojaDeParte();
        negocioUsuario		= new BusinessUsuario();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Factura factura = new Factura();
		PrintWriter out=response.getWriter();
		String modo = request.getParameter("modo");	
		
		if(modo != "new" && (request.getParameter("id")!=null)) 
		{
		factura = negocioFactura.getOne((int) Integer.parseInt(request.getParameter("id")));
		}
		switch(modo)
		{
		case "edit":
			request.setAttribute("factura", negocioFactura.getOne((int) factura.getID()));
			request.setAttribute("idf",factura.getID());
			request.setAttribute("usuario", negocioUsuario.getOne((int) factura.getUsuario().getID()));
			request.setAttribute("listaUsuarios", negocioUsuario.getAll());
			request.setAttribute("listaHojaDeParte", negocioHojaDeParte.getAll());
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("FacturaCrud.jsp").forward(request, response);
			break;
			
		case "emitir":
			request.setAttribute("factura", negocioFactura.getOne((int) factura.getID()));
			request.setAttribute("usuario", negocioUsuario.getOne((int) factura.getUsuario().getID()));
			request.setAttribute("idf",factura.getID());
			request.setAttribute("modo", modo);
			
			request.getRequestDispatcher("FacturaCrud.jsp").forward(request, response);
			break;
			
		case "new":
			ArrayList<Factura> listafactura = negocioFactura.getAll();
			int i = (int) listafactura.get(listafactura.size() - 1).getID();
			request.setAttribute("idf", i+1);
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("FacturaCrud.jsp").forward(request, response);
			break;	
		
		case "delete":
			try {
			negocioFactura.Delete(factura);}
			catch(Exception e)
			{
				  System.out.println(e.getMessage());
				
			}
			finally {response.sendRedirect("menu?page=listafacturas");}
			
			break;
		default: 
			request.getRequestDispatcher("error404.html").forward(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		
		
	}

}
