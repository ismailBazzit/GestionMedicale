package pack.Servlet;

import java.io.IOException;



import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.DAO.IMalade;
import pack.DAO.ImpMalade;
import pack.Model.Malade;

public class PatientsServlet extends HttpServlet{
	private ImpMalade malade;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		malade = new ImpMalade();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*List<Malade> list = malade.listMalade();
		if (malade != null) {
        request.setAttribute("patients", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patients.jsp");
        dispatcher.forward(request, response);
        }*/
		
		String action = request.getServletPath();
		
		try { 
        switch (action) {
		case "/newPatient":
		    showNewForm(request, response);
		    break;
		case "/insertPatient":
				insertPatient(request, response);
            break;
        case "/editPatient":
            showEditForm(request, response);
            break;
        case "/updatePatient":
            updatePatient(request, response);
            break;
        case "/deletePatient":
            deletePatient(request, response);
            break;
        case "/listPatient":
        	listPatients(request, response);
            break;
		/*default:
		    listPatients(request, response);
		    break;*/
		}
        
        } catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		malade.deleteMalade(id);
        response.sendRedirect("listPatient");
		
	}

	private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
        String nomC = request.getParameter("nomComplet");
        String dateString = request.getParameter("dateNaissance");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateN = sdf.parse(dateString);
        
        String genre = request.getParameter("gender");
        String adress = request.getParameter("adress");//tel
        String tel = request.getParameter("tel");
        
        Malade m = new Malade(id , nomC, dateN, genre,  adress,  tel);
        malade.updateMalade(m);
        response.sendRedirect("listPatient");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Malade m = malade.getMalade(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AjtPatient.jsp");
        request.setAttribute("patient", m);
        dispatcher.forward(request, response);
		
	}

	private void insertPatient(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		// TODO Auto-generated method stub
		//public Malade(String nomComplet, Date dateNaissance, String genre, String adress, String tel)
        String nomC = request.getParameter("nomComplet");
        String dateString = request.getParameter("dateNaissance");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateN = sdf.parse(dateString);
        
        String genre = request.getParameter("gender");
        String adress = request.getParameter("adress");//tel
        String tel = request.getParameter("tel");
        
        Malade m = new Malade(nomC, dateN, genre,  adress,  tel);
        malade.addMalade(m);
        response.sendRedirect("listPatient");
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        RequestDispatcher dispatcher = request.getRequestDispatcher("AjtPatient.jsp");
        dispatcher.forward(request, response);
	}

	private void listPatients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        List<Malade> list = malade.listMalade();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patients.jsp");
        dispatcher.forward(request, response);
	}



}
