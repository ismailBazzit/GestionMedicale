package pack.DAO;

import java.util.List;

import pack.Model.Symptome;


public interface ISymptome {

	public void addSymptome(Symptome symptome);
	public List<Symptome> listSymptome();
	public Symptome lastSymptome();
	public Symptome getSymptome(int idSymptome);
	public void deleteSymptome(int idSymptome);
	public void updateSymptome(Symptome symptome);
}
