package pack.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="symptome")
public class Symptome {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idS")
	private int id;
	private String nomS;
//	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "Symptomes")
//	private List<Consultation> consultations;
	@OneToMany(mappedBy = "symptome",targetEntity = Diagnostique.class,cascade = CascadeType.ALL )
	private List<Diagnostique> diagnostiques;
	
	public Symptome() {
		super();
	}
	public Symptome(String nomS) {
		super();
		this.nomS = nomS;
	}
	public Symptome(int id, String nomS) {
		super();
		this.id = id;
		this.nomS = nomS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomS() {
		return nomS;
	}
	public void setNomS(String nomS) {
		this.nomS = nomS;
	}
	public List<Diagnostique> getDiagnostiques() {
		return diagnostiques;
	}
	public void setDiagnostiques(List<Diagnostique> diagnostiques) {
		this.diagnostiques = diagnostiques;
	}
	

}
