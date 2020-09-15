package com.rahul.mainApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.Factory.HibernateUtil;
import com.rahul.model.Employee;

public class App {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSession();
			Employee employee = session.get(Employee.class, 10);

			if (session != null) {
				transaction = session.beginTransaction();

				employee.setEname("sachinrameshTendulkar");
				employee.setEage(49);

				session.update(employee);

				transaction.commit();
				System.out.println("Object modified : " + employee.getVersion() +" times!!!");

			}

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}
