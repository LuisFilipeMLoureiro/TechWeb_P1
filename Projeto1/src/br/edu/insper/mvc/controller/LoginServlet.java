package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Login;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			DAO dao = new DAO();
			

			List<Login> logins = dao.getEntrada();
			
			Boolean controle = false;
			
			for (Login login : logins) {

			if (login.getSenha().contentEquals(senha) &&  login.getUsuario().contentEquals(usuario)) {
				
				controle=true;
			}}
				
			if (controle == true)	{
				// request.setAttribute("usuario", usuario);

				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/index.html");

				dispatcher.forward(request, response);
				
			}

			else {

		
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/LoginPage.jsp");

			dispatcher.forward(request, response);

			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
