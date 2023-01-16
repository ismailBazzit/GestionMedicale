package pack.Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.DAO.ImpConsultation;
import pack.DAO.ImpDiagnostique;
import pack.DAO.ImpMalade;
import pack.DAO.ImpMaladie;
import pack.DAO.ImpMedcin;
import pack.DAO.ImpSymptome;
import pack.Model.Consultation;
import pack.Model.Diagnostique;
import pack.Model.Malade;
import pack.Model.Maladie;
import pack.Model.Medcin;
import pack.Model.Symptome;

import java.util.List;

/**
 * Servlet implementation class consultation
 */
@WebServlet("/consultation")
public class consultation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getServletPath().equals("/createConsultation")) {
			ImpMedcin impMedcin = new ImpMedcin();
			List<Medcin>medcins = impMedcin.listMedcin();
			request.setAttribute("medcins",medcins );
			
			ImpMalade impMalade = new ImpMalade();
			List<Malade>malades = impMalade.listMalade();		
			request.setAttribute("malades", malades);
			
	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Ajtcons.jsp");
		    dispatcher.forward(request, response);
			}
		
		if(request.getServletPath().equals("/Consultations")) {
			ImpConsultation impConsultation = new ImpConsultation();
			request.setAttribute("Consultations", impConsultation.listConsultation());
			RequestDispatcher dispatcher = request.getRequestDispatcher("editConsultation.jsp");
		    dispatcher.forward(request, response);
		}
		
		if(request.getServletPath().equals("/showConsultation")) {
			
			System.out.println("page editConsultation "+request.getParameter("id"));
			ImpConsultation impConsultation = new ImpConsultation();			
			Consultation consultation = impConsultation.getConsultation(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("Consultation", consultation);
			
			ImpMedcin impMedcin = new ImpMedcin();
			List<Medcin>medcins = impMedcin.listMedcin();
			request.setAttribute("medcins",medcins );
			
			ImpMalade impMalade = new ImpMalade();
			List<Malade>malades = impMalade.listMalade();		
			request.setAttribute("malades", malades);
			
			ImpDiagnostique impdiagnostique = new ImpDiagnostique();
			List<Diagnostique>diagnostiques = impdiagnostique.listDiagnostiqueConsultation(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("diagnostiques", diagnostiques);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Ajtcons.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		if(request.getServletPath().equals("/deleteConsultation")) {
			System.out.println("page deleteConsultation");
			
		}
		
		
		
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		System.out.println(request.getParameter("symall"));
		if(action.equals("/createConsultation")) {
			
			String symptoms[] = request.getParameter("symall").split(",");
			
			
			ImpMalade impMalade = new ImpMalade();
			Malade malade =  impMalade.getMalade(Integer.parseInt(request.getParameter("malade")));
			
		
			ImpMedcin impMedcin = new ImpMedcin();
			Medcin medcin = impMedcin.getMedcin(Integer.parseInt(request.getParameter("medcin")));
			
			Date date1;
			ImpConsultation impConsultation = new ImpConsultation();
			try {
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateC"));				
				impConsultation.addConsultation(new Consultation(request.getParameter("description"),date1,Float.parseFloat(request.getParameter("prix")),medcin,malade));
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			} 
			
			Consultation consultation = impConsultation.lastConsultation();
			
			
	
			ImpMaladie impMaladie = new ImpMaladie();
			impMaladie.addMaladie(new Maladie(request.getParameter("maladie"), request.getParameter("description")));
			
			Maladie maladie = impMaladie.lastMaladie();
			
			
			ImpSymptome impSymptome = new ImpSymptome();
			ImpDiagnostique impdiagnostique = new ImpDiagnostique();
			
			for (int i = 1 ; i<symptoms.length;i++) {
				
				impSymptome.addSymptome(new Symptome(symptoms[i]));
				Symptome symptome = impSymptome.lastSymptome();
				impdiagnostique.addDiagnostique(new Diagnostique(consultation, symptome, maladie));
				
			}
			System.out.println("Bien ajoute");
			
			
			
			request.setAttribute("Consultations", impConsultation.listConsultation());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Consultation.jsp");
		    dispatcher.forward(request, response);
			
		}
		
		if(action.equals("/editConsultation")) {
			System.out.println(request.getParameter("symall"));
			
			int idcon = Integer.parseInt(request.getParameter("idconsultation"));
			ImpConsultation impConsultation = new ImpConsultation();
			Consultation consultation = impConsultation.getConsultation(idcon); 
			
			ImpDiagnostique impdiagnostique = new ImpDiagnostique();
			List<Diagnostique>diagnostiques = impdiagnostique.listDiagnostiqueConsultation(idcon);
			
			ImpSymptome impSymptome = new ImpSymptome();
			ImpMaladie impMaladie = new ImpMaladie();
			
			impMaladie.deleteMaladie(diagnostiques.get(0).getMaladie().getId());
			
			for (Diagnostique diagnostique : diagnostiques) {
				impSymptome.deleteSymptome(diagnostique.getSymptome().getId());
				
			}
			
			
			String symptoms[] = request.getParameter("symall").split(",");
			
			
			ImpMalade impMalade = new ImpMalade();
			Malade malade =  impMalade.getMalade(Integer.parseInt(request.getParameter("malade")));
			
		
			ImpMedcin impMedcin = new ImpMedcin();
			Medcin medcin = impMedcin.getMedcin(Integer.parseInt(request.getParameter("medcin")));
			
			Date date1;
			
			try {
				
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateC"));	

				Consultation consultationup = new Consultation(idcon,request.getParameter("description"),date1,Float.parseFloat(request.getParameter("prix")),medcin,malade);
				System.out.print(consultation.getPrix());
				impConsultation.updateConsultation(consultationup);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			} 
			
			
			
			
	
			
			impMaladie.addMaladie(new Maladie(request.getParameter("maladie"), request.getParameter("description")));
			
			Maladie maladie = impMaladie.lastMaladie();
			
			
			
			
			for (int i = 1 ; i<symptoms.length;i++) {
				
				impSymptome.addSymptome(new Symptome(symptoms[i]));
				Symptome symptome = impSymptome.lastSymptome();
				impdiagnostique.addDiagnostique(new Diagnostique(consultation, symptome, maladie));
				
			}
	
			
			
			response.sendRedirect("Consultations");
			
		}
		
		if(action.equals("/deleteConsultation")) {
			ImpConsultation impConsultation = new ImpConsultation();
			int idcon = Integer.parseInt(request.getParameter("idCon"));
			Consultation consultation = impConsultation.getConsultation(idcon); 
			
			ImpDiagnostique impdiagnostique = new ImpDiagnostique();
			List<Diagnostique>diagnostiques = impdiagnostique.listDiagnostiqueConsultation(idcon);
			
			ImpSymptome impSymptome = new ImpSymptome();
			ImpMaladie impMaladie = new ImpMaladie();
			
			impMaladie.deleteMaladie(diagnostiques.get(0).getMaladie().getId());
			
			for (Diagnostique diagnostique : diagnostiques) {
				impSymptome.deleteSymptome(diagnostique.getSymptome().getId());
				
			}
			
			impConsultation.deleteConsultation(consultation.getId());
			response.sendRedirect("Consultations");
			
		}
		
		
	}

}
