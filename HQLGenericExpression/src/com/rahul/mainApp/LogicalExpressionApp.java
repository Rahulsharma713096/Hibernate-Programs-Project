package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.rahul.factory.HibernateUtil;

public class LogicalExpressionApp {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			speicalOperatorApp(session);
			System.out.println("---------------------------------------------------------------------");
			scalarOperations(session);
			System.out.println("-----------------------------------------------------------------------");
			LogicalOperations(session);
			
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void speicalOperatorApp(Session session) {
		String hqlSelectQuery = "select e.ename,e.eage from Employee e where e.eage BETWEEN 20 AND 50";
		Query query = session.createQuery(hqlSelectQuery);
		List<Object[]> employees = query.getResultList();

		if (employees.isEmpty()) {
			System.out.println("No Records");
		} else {

			System.out.println("ENAME\tEAGE\tEADDRESS");

			for (Object[] employee : employees) {
				for (Object emp : employee) {
					System.out.print(emp + "\t");
				}
				System.out.println();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static void scalarOperations(Session session) {
		Query query = session.createQuery("select lower(e.ename),e.eage,upper(e.eaddress) from Employee e");
		List<Object[]> employees = query.getResultList();

		if (employees.isEmpty()) {
			System.out.println("No Records");
		} else {

			System.out.println("ENAME\tEAGE\tEADDRESS");

			for (Object[] employee : employees) {
				for (Object emp : employee) {
					System.out.print(emp + "\t");
				}
				System.out.println();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static void LogicalOperations(Session session) {
		String hqlSelectQuery = "select e.eno,e.ename,e.eage from Employee e where e.eage>15 AND e.eage<=30";
		Query query = session.createQuery(hqlSelectQuery);
		List<Object[]> employees = query.getResultList();

		if (employees.isEmpty()) {
			System.out.println("No Records");
		} else {

			System.out.println("ENO\tENAME\tESALARY");

			for (Object[] employee : employees) {
				for (Object empRecord : employee) {
					System.out.print(empRecord + "\t");
				}
				System.out.println();
			}
		}
	}

}
