package pack.DAO;

import java.util.List;

import org.hibernate.Session;

import pack.Model.Medcin;

public interface IMedcin {
	public void addMedcin(Medcin medcin);
	public List<Medcin> listMedcin();
	public Medcin getMedcin(int idMedcin);
	public void deleteMedcin(int idMedcin);
	public void updateMedcin(Medcin medcin);
}
