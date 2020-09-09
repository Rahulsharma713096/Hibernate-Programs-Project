package com.rahul.main;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.rahul.Model.Employee;
import com.rahul.factory.HibernateUtil;

public class countApp {
private static Session session;

public static void main(String[] args) {
	try {
		session = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		Collection<Employee> list = session.createQuery("select count(*) from Employee").getResultList();
		System.out.println(list);
		// another way
		@SuppressWarnings("unchecked")
		List<Employee> list2 = session.createQuery("select count(eno) from Employee").list();
		System.out.println(list2);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		if(session!=null)
		HibernateUtil.close();
	}
	
}
}
