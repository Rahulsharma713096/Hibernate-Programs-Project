package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.rahul.factory.HibernateUtil;


public class ConditionBasedHQL {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Query query = session.createQuery(
					"select e.eno,e.ename,e.salary from Employee1 as e where e.salary<=20000 and e.salary>=200 order by e.ename");
			List<Object[]> employeeList = query.list();

			if (employeeList.isEmpty()) {
				System.out.println("No records found");
			} else {
				System.out.println("ENO\tENAME\tESALARY");

				// retrieving the records on the basis of selection
				for (Object[] employees : employeeList) {
					for (Object employee : employees) {
						System.out.print(employee + "\t");
					}
					System.out.println();
				}

			}

			System.out.println();

			List<Long> resultList = session.createQuery("select sum(e.salary) from Employee1 as e group by e.ename")
					.list();
			System.out.println("The total salary is :" + resultList.get(0));

			System.out.println();

			List<Long> results = session
					.createQuery("select count(e.salary)from Employee1  as e group by e.salary having e.salary>=5000")
					.list();
			System.out.println("The count is :" + results.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}
