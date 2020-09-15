package com.rahul.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.factory.HibernateUtil;
import com.rahul.model.Employee;

public class ClientApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSession();

			displayRecord(session);

			transaction = session.beginTransaction();

			int rowCount = session.getNamedQuery("deleteEmployee").executeUpdate();
			System.out.println(rowCount + " record got delted");

			transaction.commit();

			displayRecord(session);

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	private static void displayRecord(Session session) {
		List<Employee> employees = session.getNamedQuery("getEmployees").getResultList();
		System.out.println();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println();
	}

}
