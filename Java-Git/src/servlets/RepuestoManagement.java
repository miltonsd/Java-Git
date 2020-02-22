package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import business.BusinessProveedor;
import business.BusinessRepuesto;
import business.BusinessTipoRepuesto;
import entities.Repuesto;
import entities.TipoRepuesto;

/**
 * Servlet implementation class RepuestoManagement
 */
@WebServlet({ "/listadorepuestos/*","" })
public class RepuestoManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessRepuesto negocioRepuesto;
    private BusinessTipoRepuesto negocioTipoRepuesto; 
    private BusinessProveedor negocioProveedor; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepuestoManagement() {
        super();
        negocioRepuesto 	= new BusinessRepuesto();
        negocioTipoRepuesto = new BusinessTipoRepuesto();
        negocioProveedor 	= new BusinessProveedor();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Repuesto repuesto = new Repuesto();
		PrintWriter out=response.getWriter();
		String modo = request.getParameter("modo");	
		if(request.getAttribute("errormsg") != null)
		{
			request.setAttribute("errormsg", request.getAttribute("errormsg"));
		}
		if(request.getParameter("id") != null) 
		{
			repuesto = negocioRepuesto.getOne((int) Integer.parseInt(request.getParameter("id")));
		}
		
		
		switch(modo)
		{
		case "edit":
			request.setAttribute("tiporepuesto", negocioTipoRepuesto.getOne((int) repuesto.getTipoRepuesto().getID()));
			request.setAttribute("listaTipoRepuesto", negocioTipoRepuesto.getAll());
			request.setAttribute("proveedor", negocioProveedor.getOne((int) repuesto.getProveedor().getID()));
			request.setAttribute("listaProveedor", negocioProveedor.getAll());
			request.setAttribute("idr",(int) repuesto.getID());
			request.setAttribute("repuesto", repuesto);
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("RepuestoCrud.jsp").forward(request, response);
			break;
			
		case "new":
			ArrayList<Repuesto> listarepuesto = negocioRepuesto.getAll();
			int i = (int) listarepuesto.get(listarepuesto.size() - 1).getID();
			request.setAttribute("idr", i+1);
			request.setAttribute("listaTipoRepuesto", negocioTipoRepuesto.getAll() );
			request.setAttribute("listaProveedor", negocioProveedor.getAll());
			request.setAttribute("modo", modo);
			request.getRequestDispatcher("RepuestoCrud.jsp").forward(request, response);
			break;	
		
		case "delete":
				try{
				negocioRepuesto.Delete(repuesto);
				}catch(Exception e) {throw e;}
				finally{request.getRequestDispatcher("menu?page=listarepuestos").forward(request, response);}
				
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
		
	}

}
