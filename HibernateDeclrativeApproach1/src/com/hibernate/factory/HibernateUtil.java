package com.hibernate.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.pojo.Employee;

public class HibernateUtil {
private static SessionFactory bsf;
private static Session session;

static{
	Configuration cfg = new Configuration();
	
	try {
		FileInputStream fio = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\HibernateWS\\HibernateDeclrativeApproach1\\HibernateCfg.properties");
	      Properties p = new Properties();
	  p.load(fio);
	  
	  cfg.addProperties(p);
	  cfg.addAnnotatedClass(Employee.class);
	   bsf = cfg.buildSessionFactory();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Session getSession() {
		if(bsf!=null) {
			session = bsf.openSession();
		}
		else session=null;
		return session;
		
	}
	public static void close() {
		if(bsf!=null) {bsf.close();
		System.out.println("Session closed Sucessfully");
		}
		else System.out.println("Session Not Created");
	}
}
