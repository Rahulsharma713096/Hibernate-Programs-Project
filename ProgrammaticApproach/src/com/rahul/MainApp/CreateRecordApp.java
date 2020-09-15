package com.rahul.MainApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.Factory.HibernateUtil;
import com.rahul.Pojo.Employee;

public class CreateRecordApp {

	public static void main(String[] args) {

		try {

			Session session = HibernateUtil.getSession();
			int eid = 24;
			Employee employeeRecord = session.get(Employee.class, eid);
			if (employeeRecord == null) {
				Transaction transaction = session.beginTransaction();

				Employee employee = new Employee();
				employee.setEno(24);
				employee.setEname("ganguly");
				employee.setEage(49);
				employee.setEaddress("KKR");

				int pkId = (int) session.save(employee);

				transaction.commit();
				System.out.println("Employee record inserted with the id :" + pkId);

			} else {
				System.out.println("Employee record already avaialble with the id :" + eid);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}

	}

}
