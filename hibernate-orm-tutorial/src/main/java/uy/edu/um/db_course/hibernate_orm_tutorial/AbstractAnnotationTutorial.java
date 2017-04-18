package uy.edu.um.db_course.hibernate_orm_tutorial;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractAnnotationTutorial {

	public static void main(String[] args) {
		new EventAnnotationTutorial().runIt();
		
		System.exit(0);
	}

	public void runIt() {
		Configuration cfg = createConfiguration();
		
		addAnnotatedClasses(cfg);
		
		SessionFactory sessions = cfg.buildSessionFactory();
	
		testMapping(sessions);
	}

	protected abstract void testMapping(SessionFactory sessions);

	protected abstract void addAnnotatedClasses(Configuration cfg);
	
	private Configuration createConfiguration() {
		Configuration cfg = new Configuration()
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/firsttutorial")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "geocom").setProperty("hibernate.hbm2ddl.auto", "update");
		return cfg;
	}

	public AbstractAnnotationTutorial() {
		super();
	}

}