package servlets;
import entities.Proveedor;
import entities.Repuesto;
import entities.TipoRepuesto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import business.BusinessRepuesto;
import business.BusinessTipoRepuesto;
import data.DataFactura;

/**
 * Servlet implementation class RepuestoCrud
 */
@SuppressWarnings("unused")
@WebServlet("/repuesto/*")
public class RepuestoCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessRepuesto negocioRepuesto ;   
    private BusinessTipoRepuesto negocioTipoRepuesto;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepuestoCrud() {
        super();
        negocioRepuesto = new BusinessRepuesto();
        negocioTipoRepuesto = new BusinessTipoRepuesto();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Repuesto repuesto = new Repuesto();
		repuesto.setTipoRepuesto(new TipoRepuesto());
		repuesto.setProveedor(new Proveedor());
		
		switch(request.getParameter("modo"))
		{
		
		case "edit":
			repuesto.getTipoRepuesto().setID(Integer.parseInt(request.getParameter("tipoRepuestoLista")));
			repuesto.setID(Integer.parseInt(request.getParameter("id")));
			repuesto.getProveedor().setID(Integer.parseInt(request.getParameter("proveedoresLista")));
			repuesto.setDescripcion((String)request.getParameter("descripcion"));
			repuesto.setStock(Integer.parseInt(request.getParameter("stock")));
			repuesto.setPrecioUnitario(Float.parseFloat(request.getParameter("precioUnitario")));
			try {
				negocioRepuesto.Edit(repuesto);
			} catch (MySQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(repuesto.getID().toString() + repuesto.getStock() + repuesto.getProveedor().getID().toString() + repuesto.getTipoRepuesto().getID());
			response.sendRedirect("menu?page=listarepuestos");
			
			break;
		case "new":
			repuesto.getTipoRepuesto().setID(Integer.parseInt(request.getParameter("tipoRepuestoLista")));
			repuesto.getProveedor().setID(Integer.parseInt(request.getParameter("proveedoresLista")));
			repuesto.setDescripcion((String)request.getParameter("descripcion"));
			repuesto.setStock(Integer.parseInt(request.getParameter("stock")));
			repuesto.setPrecioUnitario(Float.parseFloat(request.getParameter("precioUnitario")));
			try {
				negocioRepuesto.New(repuesto);
			} catch (MySQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("menu?page=listarepuestos");
			break;
		default: 
			request.getRequestDispatcher("error404.html").forward(request,response);
		}
	}

}
