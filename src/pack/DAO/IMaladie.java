package pack.DAO;

import java.util.List;

import pack.Model.Maladie;
import pack.Model.Symptome;


public interface IMaladie {

	public void addMaladie(Maladie maladie);
	public List<Maladie> listMaladie();
	public Maladie getMaladie(int idMaladie);
	public void deleteMaladie(int idMaladie);
	public void updateMaladie(Maladie maladie);
	public Maladie lastMaladie();
}
