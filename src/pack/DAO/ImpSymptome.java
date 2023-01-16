package pack.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pack.Hibernate.HibernateUtil;
import pack.Model.Symptome;

public class ImpSymptome implements ISymptome{

	@Override
	public void addSymptome(Symptome symptome) {
		
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(symptome);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		
	}

	@Override
	public List<Symptome> listSymptome() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("select s from Symptome s");
		List<Symptome> symptomes = query.list();
		session.getTransaction().commit();
		return symptomes;
	}

	@Override
	public Symptome getSymptome(int idSymptome) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Symptome symptome = (Symptome)session.get(Symptome.class, idSymptome);
		if(symptome == null) throw new RuntimeException("Symptome introuvable");
		return symptome;
	}

	@Override
	public void deleteSymptome(int idSymptome) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Symptome symptome = (Symptome)session.get(Symptome.class, idSymptome);
		if(symptome == null) throw new RuntimeException("Symptome introuvable");
		session.delete(symptome);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateSymptome(Symptome symptome) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(session);
		session.getTransaction().commit();
	}

	@Override
	public Symptome lastSymptome() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM Symptome  ORDER by idS DESC");
		Symptome symptomes = (Symptome) query.getResultList().get(0);
		session.getTransaction().commit();
		return symptomes;
	}

}
