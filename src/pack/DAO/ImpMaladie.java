package pack.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pack.Hibernate.HibernateUtil;
import pack.Model.Maladie;
import pack.Model.Symptome;

public class ImpMaladie implements IMaladie{

	@Override
	public void addMaladie(Maladie maladie) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(maladie);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}		
		session.getTransaction().commit();
	}

	@Override
	public List<Maladie> listMaladie() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("select m from Maladie m");
		List<Maladie> maladies = query.list();
		session.getTransaction().commit();
		return maladies;
	}

	@Override
	public Maladie getMaladie(int idMaladie) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Maladie maladie =session.get(Maladie.class, idMaladie);
		if(maladie == null) throw new RuntimeException("Maladie introuvable");
		return maladie;
	}

	@Override
	public void deleteMaladie(int idMaladie) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Maladie maladie =session.get(Maladie.class, idMaladie);
		if(maladie == null) throw new RuntimeException("Maladie introuvable");
		session.delete(maladie);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateMaladie(Maladie maladie) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(maladie);
		session.getTransaction().commit();
	}

	@Override
	public Maladie lastMaladie() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM Maladie  ORDER by idMaladie DESC");
		Maladie maladie = (Maladie) query.getResultList().get(0);
		session.getTransaction().commit();
		return maladie;
	}

}
