package pack.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pack.Hibernate.HibernateUtil;
import pack.Model.Consultation;
import pack.Model.Diagnostique;

public class ImpDiagnostique implements IDiagnostique{

	@Override
	public void addDiagnostique(Diagnostique diagnostique) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(diagnostique);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		
	}

	@Override
	public List<Diagnostique> listDiagnostiques() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("select c from diagnostique c");
		List<Diagnostique> diagnostiques = query.list();
		session.getTransaction().commit();
		return diagnostiques;
	}

	@Override
	public Diagnostique getDiagnostique(int idDiagnostique) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Diagnostique diagnostique = session.get(Diagnostique.class, idDiagnostique);
		if(diagnostique == null) throw new RuntimeException("Diagnostique introuvable");
		return diagnostique;
	}

	@Override
	public void deleteDiagnostique(int idDiagnostique) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Diagnostique diagnostique = (Diagnostique)session.get(Diagnostique.class, idDiagnostique);
		if(diagnostique == null) throw new RuntimeException("Diagnostique introuvable");
		session.delete(diagnostique);
		session.getTransaction().commit();		
	}

	@Override
	public void updateDiagnostique(Diagnostique diagnostique) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(diagnostique);
		session.getTransaction().commit();
		
	}

	@Override
	public List<Diagnostique> listDiagnostiqueConsultation(int idc) {
		// SELECT d.* FROM diagnostique d,consultation c WHERE c.idC = d.id_consultation and c.idC = 5;
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query= session.createQuery("select d from Diagnostique d where d.consultation.id = "+idc);
		List<Diagnostique> diagnostiques = query.list();
		session.getTransaction().commit();
		return diagnostiques;
	}

}