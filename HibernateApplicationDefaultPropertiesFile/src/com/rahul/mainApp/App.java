package com.rahul.mainApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.Model.Employee;
import com.rahul.factory.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				int eid = 10;
				Employee employeeRecord = session.get(Employee.class, eid);
				if (employeeRecord == null) {
					transaction = session.beginTransaction();

					Employee employee = new Employee();
					employee.setEno(10);
					employee.setEname("sachin");
					employee.setEage(49);
					employee.setEaddress("MI");

					int pkId = (int) session.save(employee);

					transaction.commit();
					System.out.println("Employee record inserted with the id :" + pkId);

				} else {
					System.out.println("Employee record already avaialble with the id :" + eid);

				}
			}

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}
}
