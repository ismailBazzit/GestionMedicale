package pack.DAO;

import java.util.List;

import pack.Model.Malade;

public interface IMalade {

	public void addMalade(Malade malade);
	public List<Malade> listMalade();
	public Malade getMalade(int idMalade);
	public void deleteMalade(int idMalade);
	public void updateMalade(Malade malade);
}
