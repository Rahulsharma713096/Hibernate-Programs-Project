package com.rahul.main;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.rahul.Model.Employee;
import com.rahul.factory.HibernateUtil;

public class SumApp {
	private static Session session;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			session = HibernateUtil.getSession();
			Collection<Employee> list = session.createQuery("select sum(salary) from Employee1").getResultList();
			System.out.println(list);
			//or we can write
			List<Employee> list1 = session.createQuery("select sum(e.salary) from Employee1 as e").getResultList();
			System.out.println(list1);
			// another Table Data
			List<Employee> list2 = session.createQuery("select sum(eage) from Employee").list();
			System.out.println(list2);
			
			//or we can write
			List<Employee> list3 = session.createQuery("select sum(e.eage) from Employee as e").list();
			System.out.println(list3);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
			HibernateUtil.close();
		}
		
	}
}
