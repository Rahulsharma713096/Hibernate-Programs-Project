package com.rahul.Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahul.model.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {

		sessionFactory = new Configuration().addAnnotatedClass(Employee.class).buildSessionFactory();

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
