package com.rahul.Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahul.Pojo.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {

		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/febbatch");
		configuration.setProperty("hibernate.connection.user", "root");
		configuration.setProperty("hibernate.connection.password", "12345678");
		configuration.setProperty("hibernate.show_sql", "true");
		
		configuration.addAnnotatedClass(Employee.class);
		sessionFactory = configuration.buildSessionFactory();

	}

	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();

		} else {
			session = null;
		}
		return session;
	}

	public static void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}

	}

}
