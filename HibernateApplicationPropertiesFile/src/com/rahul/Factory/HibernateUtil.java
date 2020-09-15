package com.rahul.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahul.Model.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	static {

		Configuration configuration = new Configuration();

		try {
			String path = "C:\\Users\\HP\\eclipse-workspace\\HibernateWS\\HibernateApplicationPropertiesFile\\src\\com\\rahul\\Resource\\hibernate.properties";
			System.out.println(path);
			
			FileInputStream fileInputStream = new FileInputStream(path);
			Properties properties = new Properties();
			properties.load(fileInputStream);
            if(properties!=null) System.out.println("Properties get loaded");
			configuration.addProperties(properties);

			configuration.addAnnotatedClass(Employee.class);

			sessionFactory = configuration.buildSessionFactory();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
