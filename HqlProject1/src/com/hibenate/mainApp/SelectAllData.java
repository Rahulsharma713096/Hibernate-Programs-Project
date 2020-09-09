package com.hibenate.mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibenate.Model.Employee;
import com.hibenate.factory.HibernateUtil;

public class SelectAllData {
public static void main(String[] args) {
	try {
		Session ses = HibernateUtil.getSession();
		String query="from Employee";
		Query<Employee> quer = ses.createQuery(query,Employee.class);
		List<Employee> rs1 = quer.getResultList();
		for (Employee employee : rs1) {
			System.out.println(employee);
		}
		System.out.println("-----------------------------------------------------------------");
	  List<Employee> rs2 = ses.createQuery(query,Employee.class).getResultList();	
	  for (Employee employee : rs2) {
			System.out.println(employee);
			}
			List<Employee> list = quer.list();
			System.out.println("------------------------------------------------------------------");
			for (Employee employee1 :list) {
				System.out.println(employee1);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		HibernateUtil.close();
	}
}
}
