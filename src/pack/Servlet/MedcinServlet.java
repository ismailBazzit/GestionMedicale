package pack.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.DAO.ImpMedcin;
import pack.Model.Medcin;


public class MedcinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImpMedcin impmedcin;

	public void init() {
		impmedcin = new ImpMedcin();
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("test");
			doGet(request, response);
			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newMedcin":
				showNewForm(request, response);
				break;
			case "/insertMedcin":
				insertMedcin(request, response);
				break;
			case "/deleteMedcin":
				deleteMedcin(request, response);
				break;
			case "/editMedcin":
				showEditForm(request, response);
				break;
			case "/updateMedcin":
				updateMedcin(request, response);
				break;
			case "/listMedcin":
				listMedcins(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listMedcins(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Medcin> list = impmedcin.listMedcin();
		request.setAttribute("list",list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AjtMedecin.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int idM = Integer.parseInt(request.getParameter("idM"));
		Medcin existingMedcin = impmedcin.getMedcin(idM);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AjtMedecin.jsp");
		request.setAttribute("medcin", existingMedcin);
		dispatcher.forward(request, response);
	}

	private void insertMedcin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String email = request.getParameter("email");
		String nomComplet = request.getParameter("nomComplet");
		String specialite = request.getParameter("specialite");
		String tel = request.getParameter("tel");
		Medcin newMedcin = new Medcin(nomComplet,specialite,email,tel);
		impmedcin.addMedcin(newMedcin);
		response.sendRedirect("listMedcin");
	}

	private void updateMedcin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int idM = Integer.parseInt(request.getParameter("idM"));
		String email = request.getParameter("email");
		String nomComplet = request.getParameter("nomComplet");
		String specialite = request.getParameter("specialite");
		String tel = request.getParameter("tel");
		
		Medcin newMedcin = new Medcin(idM,nomComplet,specialite,email,tel);
		
		impmedcin.updateMedcin(newMedcin);
		response.sendRedirect("listMedcin");
	}

	private void deleteMedcin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int idM = Integer.parseInt(request.getParameter("idM"));
		impmedcin.deleteMedcin(idM);
		response.sendRedirect("listMedcin");
	}
}
