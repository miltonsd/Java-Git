package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.BusinessAutomovil;
import business.BusinessFactura;
import business.BusinessHojaDeParte;
import business.BusinessProveedor;
import business.BusinessRepuesto;
import business.BusinessTipoRepuesto;
import business.BusinessUsuario;
import entities.Factura;
import entities.HojaDeParte;

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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HojaDeParteManagement() {
        super();
        negocioRepuesto 	= new BusinessRepuesto();
        negocioTipoRepuesto = new BusinessTipoRepuesto();
        negocioProveedor 	= new BusinessProveedor();
        negocioFactura		= new BusinessFactura();
        negocioHojaDeParte	= new BusinessHojaDeParte();
        negocioUsuario		= new BusinessUsuario();
        negocioAutomovil	= new BusinessAutomovil();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HojaDeParte hoja = new HojaDeParte();
		PrintWriter out=response.getWriter();
		String modo = request.getParameter("modo");	
		hoja.setFactura(new Factura());
		hoja.getFactura().setID((Integer.parseInt(request.getParameter("idFactura")))) ;
		if(modo != "new" && (request.getParameter("id")!=null)) 
		{
		hoja = negocioHojaDeParte.getOne((int) Integer.parseInt(request.getParameter("id")));
		}
		switch(modo)
		{
		case "edit":
			request.setAttribute("hoja", negocioHojaDeParte.getOne((int) hoja.getID()));
			request.setAttribute("idh",hoja.getID());
			request.setAttribute("mecanico", negocioUsuario.getOne((int) hoja.getMecanico().getID()));
			request.setAttribute("listaUsuarios", negocioUsuario.getAll());
			request.setAttribute("listaAutomoviles", negocioAutomovil.getAll());
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("HojaDeParteCrud.jsp").forward(request, response);
			break;
			
	
			
		case "new":
			ArrayList<HojaDeParte> hojas = negocioHojaDeParte.getAll();
			int i = (int) hojas.get(hojas.size() - 1).getID();
			request.setAttribute("idh", i+1);
			request.setAttribute("idf", hoja.getFactura().getID());
			request.setAttribute("modo", modo);
			request.setAttribute("listaUsuarios", negocioUsuario.getAll());
			request.getRequestDispatcher("HojaDeParteCrud.jsp").forward(request, response);
			break;	
		
		case "delete":
			try {
			negocioHojaDeParte.Delete(hoja);}
			catch(Exception e)
			{
				  System.out.println(e.getMessage());
				
			}
			finally {response.sendRedirect("menu?page=listahojasdeparte");}
			
			break;
		default: 
			request.getRequestDispatcher("error404.html").forward(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
