package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;

import com.rahul.Model.Employee1;
import com.rahul.factory.HibernateUtil;

public class AirthmeticApp {
private static Session session;

@SuppressWarnings({ "unchecked" })
public static void main(String[] args) {
	try {
		// ADD (+)
		 session = HibernateUtil.getSession();
		 List<Employee1> resultList = session.createQuery("select (e.salary+500) from Employee1 as e").getResultList();
		 for (Object employee1 : resultList) {
			System.out.print(employee1+", ");
		}
		 System.out.println();
		 //sub (-)
		 List<Employee1> resultList1 = session.createQuery("select (salary-500) from Employee1").getResultList();
		 System.out.println(resultList1);
		 //Mul (*)
		 List<Employee1> resultList2 = session.createQuery("select (salary*500) from Employee1").getResultList();
		 System.out.println(resultList2);
		 //Div (/)
		 List<Employee1> resultList3 = session.createQuery("select (salary/2) from Employee1").getResultList();
		 System.out.println("50% of salary of every employee \n"+resultList3);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		HibernateUtil.close();
	}
}
}
