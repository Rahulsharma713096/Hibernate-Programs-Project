package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;

import com.rahul.Model.Employee;
import com.rahul.Model.Employee1;
import com.rahul.factory.HibernateUtil;

public class LogicalApp {
private static Session session;

@SuppressWarnings("unchecked")
public static void main(String[] args) {
	 try {
		 session = HibernateUtil.getSession();
		 
		 // 1. AND
		 System.out.println("AND");
		List<Employee> list = session.createQuery("from Employee where eno>5 AND eno<10").getResultList();
		 System.out.println(list);
		 System.out.println("--------------------------------------------------------------------------------");
		 for (Employee employee : list) {
			System.out.println(employee);
		}
		 System.out.println("_________________________________________________________________________________");
		 //another Way
		 List<Employee1> list1 = session.createQuery("from Employee1 as e where e.eno>5 AND e.eno<10").getResultList();
		 for (Employee1 employee : list1) {
			System.out.println(employee);
		 }
			//OR
			 System.out.println("_________________________________________________________________________________");
			 System.out.println("OR");
			 List<Employee> list2 = session.createQuery("from Employee as e where e.eno<5 OR e.eno>10").getResultList();
			 for (Employee employee1 : list2) {
				System.out.println(employee1);
			 }
			//NOT
			 System.out.println("_________________________________________________________________________________");
			 System.out.println("NOT");
			 List<Employee> list3 = session.createQuery("from Employee as e where NOT e.eno>10").getResultList();
			 for (Employee employee1 : list3) {
				System.out.println(employee1);
			 }
			 System.out.println("---------------------------------------------------------------------");
			 //Another Way
			 List<Employee> list4 = session.createQuery("from Employee where NOT eno<10").getResultList();
			 for (Employee employee1 : list4) {
				System.out.println(employee1);
			 }
		 
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(session!=null)
		HibernateUtil.close();
	}
}
}
