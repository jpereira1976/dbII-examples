package uy.edu.um.db_course.hibernate_orm_tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class FirstAnnotationTutorial {

	public static void main(String[] args) {

		Configuration cfg = new AnnotationConfiguration().addAnnotatedClass(Event.class)
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/firsttutorial")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "geocom").setProperty("hibernate.hbm2ddl.auto", "update");

		SessionFactory sessions = cfg.buildSessionFactory();


		Transaction tx = null;
		Session session = null;
		
		try {
			session = sessions.openSession();
			tx = session.beginTransaction();
			session.save(new Event("Primer evento anotado!!!"));
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
}
