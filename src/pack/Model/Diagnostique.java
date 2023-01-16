package pack.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="diagnostique")
public class Diagnostique implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idD")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_consultation")
	private Consultation consultation;
	@ManyToOne
	@JoinColumn(name="id_symptome")
	private Symptome symptome;
	@ManyToOne
	@JoinColumn(name="id_maladie")
	private Maladie maladie;
	
	public Diagnostique() {
		super();
	}


	public Diagnostique(Consultation consultation, Symptome symptome, Maladie maladie) {
		super();
		this.consultation = consultation;
		this.symptome = symptome;
		this.maladie = maladie;
	}


	public Diagnostique(int id, Consultation consultation, Symptome symptome, Maladie maladie) {
		super();
		this.id = id;
		this.consultation = consultation;
		this.symptome = symptome;
		this.maladie = maladie;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Consultation getConsultation() {
		return consultation;
	}


	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}


	public Symptome getSymptome() {
		return symptome;
	}


	public void setSymptome(Symptome symptome) {
		this.symptome = symptome;
	}


	public Maladie getMaladie() {
		return maladie;
	}


	public void setMaladie(Maladie maladie) {
		this.maladie = maladie;
	}
	

}
