package com.rahul.MainApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.Factory.HibernateUtil;
import com.rahul.Pojo.Employee;

public class InsertRecordApp {

	public static void main(String[] args) {

		try {
			// Get the session object
			Session session = HibernateUtil.getSession();

			// Get the transaction object(insert,update,delete)
			Transaction transaction = session.getTransaction();
			transaction.begin();

			// Perform PERSISTANCE Operation(CRUD)
			Employee employee = new Employee();

			employee.setEno(7);
			employee.setEname("dhoni");
			employee.setEage(39);
			employee.setEaddress("CSK");

			session.persist(employee);// Generates insert query by HBN software

			transaction.commit();// It will make the changes to the database as per the Query

			System.out.println("Employee record got saved with the id :" + employee.getEno());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the factory Object
			HibernateUtil.close();
		}
	}

}
