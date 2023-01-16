package pack.DAO;

import java.util.List;

import pack.Model.Consultation;


public interface IConsultation {

	public void addConsultation(Consultation consultation);
	public List<Consultation> listConsultation();
	public Consultation getConsultation(int idConsultation);
	public void deleteConsultation(int idConsultation);
	public void updateConsultation(Consultation consultation);
	public Consultation lastConsultation();
}
