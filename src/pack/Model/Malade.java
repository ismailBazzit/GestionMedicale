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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="malade")
public class Malade implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idMalade")
	private int id;
	private String nomComplet;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String genre;
	private String adress;
	private String tel;
	@OneToMany(mappedBy = "malade",targetEntity = Consultation.class,cascade = CascadeType.ALL )
	private List<Consultation> consultations;
	
	
	public Malade() {
		super();
	}
	
	public Malade(String nomComplet, Date dateNaissance, String genre, String adress, String tel) {
		super();
		this.nomComplet = nomComplet;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.adress = adress;
		this.tel = tel;
	}
	
	public Malade(int id, String nomComplet, Date dateNaissance, String genre, String adress, String tel) {
		super();
		this.id = id;
		this.nomComplet = nomComplet;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.adress = adress;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	
	
}
