package pack.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pack.Hibernate.HibernateUtil;
import pack.Model.Consultation;

public class ImpConsultation implements IConsultation{

	@Override
	public void addConsultation(Consultation consultation) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(consultation);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		
	}

	@Override
	public List<Consultation> listConsultation() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("select c from Consultation c");
		List<Consultation> consultations = query.list();
		session.getTransaction().commit();
		return consultations;
	}

	@Override
	public Consultation getConsultation(int idConsultation) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Consultation consultation = session.get(Consultation.class, idConsultation);
		if(consultation == null) throw new RuntimeException("Consultation introuvable");
		return consultation;
	}

	@Override
	public void deleteConsultation(int idConsultation) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Consultation consultation = (Consultation)session.get(Consultation.class, idConsultation);
		if(consultation == null) throw new RuntimeException("Consultation introuvable");
		session.delete(consultation);
		session.getTransaction().commit();
	}

	@Override
	public void updateConsultation(Consultation consultation) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(consultation);
		session.getTransaction().commit();
	}

	@Override
	public Consultation lastConsultation() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM Consultation c ORDER by c.id DESC");
		Consultation consultation = (Consultation) query.getResultList().get(0);
		session.getTransaction().commit();
		return consultation;
	}

}
