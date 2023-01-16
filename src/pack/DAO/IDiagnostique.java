package pack.DAO;

import java.util.List;

import pack.Model.Consultation;
import pack.Model.Diagnostique;

public interface IDiagnostique {

	public void addDiagnostique(Diagnostique diagnostique);
	public List<Diagnostique> listDiagnostiques();
	public List<Diagnostique> listDiagnostiqueConsultation(int idc);
	public Diagnostique getDiagnostique(int idDiagnostique);
	public void deleteDiagnostique(int idDiagnostique);
	public void updateDiagnostique(Diagnostique diagnostique);
}
