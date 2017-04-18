package uy.edu.um.db_course.hibernate_orm_tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EventAnnotationTutorial extends AbstractAnnotationTutorial {

	
	protected void testMapping(SessionFactory sessions) {
		Transaction tx = null;
		Session session = null;
		
		try {
			session = sessions.openSession();
			tx = session.beginTransaction();
			session.save(new Event("Primer anotado!!!"));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();				
		}
	}

	protected void addAnnotatedClasses(Configuration cfg) {
		cfg.addAnnotatedClass(Event.class);
		
	}
}
