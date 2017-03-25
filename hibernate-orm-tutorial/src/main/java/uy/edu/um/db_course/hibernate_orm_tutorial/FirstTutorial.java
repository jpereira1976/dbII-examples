package uy.edu.um.db_course.hibernate_orm_tutorial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FirstTutorial {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().addResource("/Event.hbm.xml")
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/firsttutorial")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "geocom").setProperty("hibernate.hbm2ddl.auto", "update");

		SessionFactory sessions = cfg.buildSessionFactory();

		Session session = sessions.openSession();

		session.save(new Event("Primer evento!!!"));

		Event event4 = session.load(Event.class, 4L );
		
		session.beginTransaction();
		event4.setEnabled(true);
		event4.setDate(new Date());
		session.update(event4);
		session.getTransaction().commit();

		System.out.println(event4.getId());

		Query<Event> query = session.createQuery("from Event where enabled = :enabledParameter");
		query.setParameter("enabledParameter", false);
		for (Event event : query.list())
			System.out.println(event.getId());
		
		
		session.close();
		
		System.exit(0);
	}
}
