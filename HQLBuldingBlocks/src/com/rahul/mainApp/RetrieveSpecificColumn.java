package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.rahul.factory.HibernateUtil;


public class RetrieveSpecificColumn {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			
			Query query = session.createQuery("select e.eno,e.ename,e.eage from Employee e");
			List<Object[]> employeeList = query.list();
			
			System.out.println("ENO\tENAME\tEAGE");
			
			//retrieving the records on the basis of selection
			for (Object[] employees : employeeList) {
				for (Object employee : employees) {
					System.out.print(employee+"\t");
				}
				System.out.println();
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
