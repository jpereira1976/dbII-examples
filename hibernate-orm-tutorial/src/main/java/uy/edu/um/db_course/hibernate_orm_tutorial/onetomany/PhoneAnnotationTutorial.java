package uy.edu.um.db_course.hibernate_orm_tutorial.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import uy.edu.um.db_course.hibernate_orm_tutorial.AbstractAnnotationTutorial;

public class PhoneAnnotationTutorial extends AbstractAnnotationTutorial {

	@Override
	protected void testMapping(SessionFactory sessions) {
		Transaction tx = null;
		Session session = null;
		
		try {
			session = sessions.openSession();
			tx = session.beginTransaction();

			Person person = new Person();
			session.save( person );

			Phone phone = new Phone( "123-456-7890" );
			phone.setPerson( person );
			session.save( phone );

//			phone.setPerson( null );
			
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

	@Override
	protected void addAnnotatedClasses(Configuration cfg) {
		cfg.addAnnotatedClass(Phone.class);
		cfg.addAnnotatedClass(Person.class);

	}

	public static void main(String[] args) {
		new PhoneAnnotationTutorial().runIt();
		System.exit(0);
	}
}
