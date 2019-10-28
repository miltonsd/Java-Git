package servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.*;

import entities.Usuario;
/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BusinessUsuario bu = new BusinessUsuario();
		Usuario usu = new Usuario();
		HttpSession session = request.getSession();
		usu.setEmail(request.getParameter("Email"));
		usu.setPassword(request.getParameter("Password"));
		
		if(bu.verificarUsuario(usu))
		{
			session.setAttribute("UsuarioId", bu.getOnePorEmail(usu.getEmail()).getID());
			session.setAttribute("UsuarioNombre", bu.getOnePorEmail(usu.getEmail()).getNombre());
			session.setAttribute("UsuarioRol", bu.getOnePorEmail(usu.getEmail()).getRol());
			response.sendRedirect("menu.jsp");
		}
		else
		{
		
			response.sendRedirect("login.jsp");
		}
	}

}
