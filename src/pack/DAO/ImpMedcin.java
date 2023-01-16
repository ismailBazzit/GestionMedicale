package pack.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pack.Hibernate.HibernateUtil;
import pack.Model.Medcin;

public class ImpMedcin implements IMedcin{
	
	@Override
	public void addMedcin(Medcin medcin) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(medcin);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}


	@Override
	public List<Medcin> listMedcin() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("select m from Medcin m");
		List<Medcin> medcins= query.list();
		session.getTransaction().commit();
		return medcins;
	}

	@Override
	public Medcin getMedcin(int idMedcin) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Medcin medcin = (Medcin)session.get(Medcin.class, idMedcin);
		if(medcin == null) throw new RuntimeException("Medcin introuvable");
		return medcin;
	}

	@Override
	public void deleteMedcin(int idMedcin) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Medcin medcin = (Medcin)session.get(Medcin.class, idMedcin);
		if(medcin == null) throw new RuntimeException("Medcin introuvable");
		session.delete(medcin);
		session.getTransaction().commit();
	}

	@Override
	public void updateMedcin(Medcin medcin) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(medcin);
		session.getTransaction().commit();
	}



}