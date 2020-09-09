package com.hibenate.mainApp;

import java.util.List;

import org.hibernate.Session;

import com.hibenate.Model.Employee;
import com.hibenate.factory.HibernateUtil;

public class select1recordHql {
public static void main(String[] args) {
	try {
		Session ses = HibernateUtil.getSession();
		List<Employee> resultList = ses.createQuery("from Employee where eno=1",Employee.class).getResultList();
		for (Employee employee : resultList) {
			System.out.println(employee);
		}
		System.out.println("----------------------------------------------------------");
	List<?> resultList1 = ses.createQuery("from Employee where eno=1").getResultList();
		System.out.println(resultList1);
		
	}catch(Exception w) {
		w.printStackTrace();
	}finally {
		HibernateUtil.close();
	}
}
}
