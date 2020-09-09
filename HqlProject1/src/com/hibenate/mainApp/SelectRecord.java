package com.hibenate.mainApp;

import java.util.List;

import org.hibernate.Session;

import com.hibenate.Model.Employee;
import com.hibenate.factory.HibernateUtil;

public class SelectRecord {

	public static void main(String[] args) {
		Session session = null;

		try {

			// Getting the session Object
			session = HibernateUtil.getSession();

			String hqlSelectQuery = "from Employee";

			// Executing HQLSelect Query and getting List of Employees
			List<Employee> employees = session.createQuery(hqlSelectQuery, Employee.class).getResultList();
			for (Employee employee : employees) {
				System.out.println(employee);
			}

			System.out.println();

			List<Employee> tempEmployees = session.createQuery(hqlSelectQuery, Employee.class).list();
			for (Employee employee : tempEmployees) {
				System.out.println(employee);
			}

			System.out.println();

			String SqlUniqueRecord = "from Employee where eno=100";
			Employee employee = session.createQuery(SqlUniqueRecord, Employee.class).uniqueResult();
			if (employee == null) {
				System.out.println("Employee Record doesnot exists");
			} else {
				System.out.println(employee);
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
