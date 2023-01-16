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
@Table(name="maladie")
public class Maladie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMaladie")
	private int id;
	private String nomM;
	private String description;
//	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "Maladies")
//	private List<Consultation> consultations;
	@OneToMany(mappedBy = "maladie",targetEntity = Diagnostique.class,cascade = CascadeType.ALL )
	private List<Diagnostique> diagnostiques;
	
	public Maladie() {
		super();
	}
	
	public Maladie(String nomM, String description) {
		super();
		this.nomM = nomM;
		this.description = description;
	}
	
	public Maladie(int id, String nomM, String description) {
		super();
		this.id = id;
		this.nomM = nomM;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomM() {
		return nomM;
	}

	public void setNomM(String nomM) {
		this.nomM = nomM;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Diagnostique> getDiagnostiques() {
		return diagnostiques;
	}

	public void setDiagnostiques(List<Diagnostique> diagnostiques) {
		this.diagnostiques = diagnostiques;
	}
	
	
	
}
