package com.rahul.main;

import java.util.List;

import org.hibernate.Session;

import com.rahul.factory.HibernateUtil;


public class MinMaxApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			String hqlSelectQuery = "select min(e.salary) from Employee1 as e";
			List<Long> employeeminSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("The minium salary is :" + employeeminSalary.get(0));

			System.out.println();

			hqlSelectQuery = "select max(e.salary) from Employee1 as e";
			List<Long> employeemaxSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("The maximum salary is :" + employeemaxSalary.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}
