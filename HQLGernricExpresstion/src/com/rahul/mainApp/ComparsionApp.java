package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;

import com.rahul.Model.Employee1;
import com.rahul.factory.HibernateUtil;

public class ComparsionApp {
private static Session session;

@SuppressWarnings("unchecked")
public static void main(String[] args) {
	try {
		session = HibernateUtil.getSession();
		// Graterthan (>)
		System.out.println("Gaterthan (>)");
		List<Employee1> list = session.createQuery("from Employee1 where salary>2000").getResultList();
		for (Employee1 employee : list) {
			System.out.println(employee);
		}
		//Lessthan (<)
		//GraterthanEqualTO (>=)
		//LessthanEqualTo (<=)
		//NotEqualto  (!=)
		//NotEqualto  (^=)
		//NotEqualto  (<>)
		//EqualTo (=)
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}  finally {
		if(session!=null) HibernateUtil.close();
	}
	
	
}
}
