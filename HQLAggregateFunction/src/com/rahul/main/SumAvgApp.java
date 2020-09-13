package com.rahul.main;

import java.util.List;

import org.hibernate.Session;

import com.rahul.factory.HibernateUtil;


public class SumAvgApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			String hqlSelectQuery = "select sum(e.salary) from Employee1 as e";
			List<Long> employeeTotalSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("Total Salary of employee is :" + employeeTotalSalary.get(0));

			System.out.println();

			hqlSelectQuery = "select avg(e.salary) from Employee1 as e";
			employeeTotalSalary = session.createQuery(hqlSelectQuery).getResultList();
			System.out.println("Avergage Salary of employee is :" + employeeTotalSalary.get(0));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}
