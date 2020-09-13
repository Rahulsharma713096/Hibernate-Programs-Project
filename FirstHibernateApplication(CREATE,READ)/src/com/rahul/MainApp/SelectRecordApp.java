package com.rahul.MainApp;

import org.hibernate.Session;

import com.rahul.Factory.HibernateUtil;
import com.rahul.Pojo.Employee;

public class SelectRecordApp {

	public static void main(String[] args) {

		try {

			// Get the session object
			Session session = HibernateUtil.getSession();

			// Gets the employee record in the form of POJO object
			int id = 1;
			Employee employee = session.get(Employee.class, id);

			if (employee == null) {
				System.out.println("Employee Record doesnot exists for the id :"+id);
			} else {
				System.out.println("Employee object details are :");
				System.out.println("Employee NO is            :" + employee.getEno());
				System.out.println("Employee Name is          :" + employee.getEname());
				System.out.println("Employee Age is           :" + employee.getEage());
				System.out.println("Employee Address is       :" + employee.getEaddress());
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}

	}

}
