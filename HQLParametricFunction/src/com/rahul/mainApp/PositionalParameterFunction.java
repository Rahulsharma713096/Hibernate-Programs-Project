package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rahul.factory.HibernateUtil;

@SuppressWarnings({ "deprecation", "unused" })
public class PositionalParameterFunction {
	// This Code Only supports Hibernate4.X
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			List<Object[]> employeeList = session
					.createQuery("select e.eno,e.ename,e.eage,e.salary from Employee1 as e where e.eno=?")
					.setParameter(0, 10).list();
			
			if (!employeeList.isEmpty()) {
				for (Object[] employees : employeeList) {
					for (Object employee : employees) {
						System.out.print(employee + "\t");
					}
					System.out.println();
				}
			} else {
				System.out.println("No record found");
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
