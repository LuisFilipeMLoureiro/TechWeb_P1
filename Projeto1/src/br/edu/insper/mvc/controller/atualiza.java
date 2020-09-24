package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefa;

/**
 * Servlet implementation class atualiza
 */
@WebServlet("/atualiza")
public class atualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public atualiza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Tarefa tarefa = new Tarefa();
		
		
		tarefa.setTitulo(request.getParameter("Titulo"));
		tarefa.setDescricao(request.getParameter("Descricao"));
		tarefa.setImportancia(Integer.valueOf(request.getParameter("Importancia")));
		tarefa.setId(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("tarefa", tarefa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/atualiza.jsp");
		dispatcher.forward(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			DAO dao = new DAO();
			Tarefa tarefa = new Tarefa();
			tarefa.setTitulo(request.getParameter("Titulo"));
			tarefa.setDescricao(request.getParameter("Descricao"));
			tarefa.setImportancia(Integer.valueOf(request.getParameter("Importancia")));
			tarefa.setId(Integer.valueOf(request.getParameter("id")));
			dao.atualiza(tarefa);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
			dispatcher.forward(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}

}
