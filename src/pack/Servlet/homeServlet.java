package pack.Servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.DAO.ImpConsultation;
import pack.DAO.ImpMalade;
import pack.DAO.ImpMedcin;
import pack.Model.Consultation;
import pack.Model.Malade;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
	ImpMedcin impMedcin = new ImpMedcin();
	ImpMalade impMalade = new ImpMalade();
	ImpConsultation impConsultation = new ImpConsultation();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Consultation> consultations = impConsultation.listConsultation();
		Collections.reverse(consultations);
		List<Malade> malades = impMalade.listMalade();
		Collections.reverse(malades);
		request.setAttribute("nbrMedcins", impMedcin.listMedcin().size());
		request.setAttribute("nbrMalades", impMalade.listMalade().size());
		request.setAttribute("nbrConsultation", impConsultation.listConsultation().size());
		request.setAttribute("consultations",consultations);
		request.setAttribute("malades", malades);
		this.getServletContext().getRequestDispatcher( "/Dashboard.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
