package com.rahul.mainApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.factory.HibernateUtil;
import com.rahul.model.Employee;

public class CreateRecordApp {
	public static void main(String[] args) {

		try {

			Session session = HibernateUtil.getSession();
			int eid = 20;
			Employee employeeRecord = session.get(Employee.class, eid);
			if (employeeRecord == null) {
				Transaction transaction = session.beginTransaction();

				Employee employee = new Employee();
				employee.setEno(eid);
				employee.setEname("Ram");
				employee.setEage(49);
				employee.setEaddress("RCB");

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
