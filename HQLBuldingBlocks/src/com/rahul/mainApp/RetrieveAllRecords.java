package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;

import com.rahul.Model.Employee1;
import com.rahul.factory.HibernateUtil;


public class RetrieveAllRecords {

	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			List<Employee1> employees = session.createQuery("FROM Employee1 e", Employee1.class).list();
			System.out.println("ENO\tENAME\tEAGE\tESALARY");
			for (Employee1 employee : employees) {
				System.out.println(employee.getEno() + "\t" + employee.getEname() + "\t" + employee.getEage() + "\t"
						+ employee.getSalary());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}
