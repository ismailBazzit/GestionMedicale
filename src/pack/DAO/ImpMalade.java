package pack.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pack.Hibernate.HibernateUtil;
import pack.Model.Malade;

public class ImpMalade implements IMalade{

	@Override
	public void addMalade(Malade malade) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(malade);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		
	}

	@Override
	public List<Malade> listMalade() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("select m from Malade m");
		List<Malade> malades = query.list();
		session.getTransaction().commit();
		return malades;
	}

	@Override
	public Malade getMalade(int id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Malade malade = (Malade)session.get(Malade.class, id);
		if(malade == null) throw new RuntimeException("Malade introuvable");
		return malade;
	}

	@Override
	public void deleteMalade(int id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Malade malade = session.get(Malade.class, id);
		if(malade == null) throw new RuntimeException("Malade introuvable");
		session.delete(malade);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateMalade(Malade malade) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(malade);
		session.getTransaction().commit();
	}

}
