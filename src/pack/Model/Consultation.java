package pack.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="consultation")
public class Consultation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idC")
	private int id;
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateC;
	
	private float prix;
	
	@ManyToOne
	@JoinColumn(name="id_medcin")
	private Medcin medcin;
	
	@ManyToOne
	@JoinColumn(name="id_malade")
	private Malade malade;
	
	@OneToMany(mappedBy = "consultation",targetEntity = Diagnostique.class,cascade = CascadeType.ALL )
	private List<Diagnostique> diagnostiques;

	
//	@ManyToMany 
//	@JoinTable(name="Diagnostiques",
//		joinColumns = @JoinColumn(name="id_consultaion"),
//		inverseJoinColumns = { @JoinColumn(name="idS",table = "Symptomes"),@JoinColumn(name="idMaladie", table = "Maladies")})
//	private List<Symptome>symptomes;
//	@ManyToMany
//	private List<Malade>maladies;
	
	public Consultation() {
		super();
	}


	public Consultation(String description, Date dateC, float prix, Medcin medcin, Malade malade) {
		super();
		this.description = description;
		this.dateC = dateC;
		this.prix = prix;
		this.medcin = medcin;
		this.malade = malade;
	}


	public Consultation(int id, String description, Date dateC, float prix, Medcin medcin, Malade malade) {
		super();
		this.id = id;
		this.description = description;
		this.dateC = dateC;
		this.prix = prix;
		this.medcin = medcin;
		this.malade = malade;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateC() {
		return dateC;
	}


	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public Medcin getMedcin() {
		return medcin;
	}


	public void setMedcin(Medcin medcin) {
		this.medcin = medcin;
	}


	public Malade getMalade() {
		return malade;
	}


	public void setMalade(Malade malade) {
		this.malade = malade;
	}


	public List<Diagnostique> getDiagnostiques() {
		return diagnostiques;
	}


	public void setDiagnostiques(List<Diagnostique> diagnostiques) {
		this.diagnostiques = diagnostiques;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


}
