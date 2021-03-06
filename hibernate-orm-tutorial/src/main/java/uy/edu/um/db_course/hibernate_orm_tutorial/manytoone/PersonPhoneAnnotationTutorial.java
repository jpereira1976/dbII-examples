package uy.edu.um.db_course.hibernate_orm_tutorial.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import uy.edu.um.db_course.hibernate_orm_tutorial.AbstractAnnotationTutorial;


public class PersonPhoneAnnotationTutorial extends AbstractAnnotationTutorial {

	@Override
	protected void testMapping(SessionFactory sessions) {
		Transaction tx = null;
		Session session = null;
		
		try {
			session = sessions.openSession();
			tx = session.beginTransaction();

			Person person = new Person();
			Phone phone1 = new Phone( "123-456-7890" );
			Phone phone2 = new Phone( "321-654-0987" );

			person.getPhones().add( phone1 );
			person.getPhones().add( phone2 );
			session.save( person );
			
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
		cfg.addAnnotatedClass(Person.class).addAnnotatedClass(Phone.class);
	}
	
	public static void main(String[] args) {
		new PersonPhoneAnnotationTutorial().runIt();
		
		System.exit(0);
	}

}
