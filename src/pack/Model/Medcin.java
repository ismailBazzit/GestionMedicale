package pack.Model;

import java.io.Serializable;
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

@Entity
@Table(name="medcin")
public class Medcin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idM")
	private int id;	
	private String nomComplet;
	private String specialite;
	private String email;
	private String tel;
	
	@OneToMany(mappedBy = "medcin",targetEntity = Consultation.class,cascade = CascadeType.ALL )
	private List<Consultation> consultations;
	
	public Medcin() {
		super();
	}
	public Medcin(String nomComplet, String specialite, String email, String tel) {
		super();
		this.nomComplet = nomComplet;
		this.specialite = specialite;
		this.email = email;
		this.tel = tel;
	}
	
	public Medcin(int id, String nomComplet, String specialite, String email, String tel) {
		super();
		this.id = id;
		this.nomComplet = nomComplet;
		this.specialite = specialite;
		this.email = email;
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
	public String getSpecialite() {
		return specialite;
	}
	public List<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

}