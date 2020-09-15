package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.rahul.factory.HibernateUtil;
import com.rahul.model.Employee;

public class App {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			// 1.create the query
			NativeQuery query = session.createSQLQuery("select * from `EMPLOYEE1`");
			query.addEntity(Employee.class);

			// 2.Execute the query
			List<Employee> employees = query.getResultList();

			// 3.Display the result
			for (Employee employee : employees) {
				System.out.println(employee);
			}

		} catch (Exception e) {

		}

	}

}
