package com.hibenate.mainApp;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibenate.factory.HibernateUtil;

public class NonSelectRecord {
	public static void main(String[] args) {
		Session session = null;

		try {

			// Getting the session Object
			session = HibernateUtil.getSession();

			Transaction transaction = session.beginTransaction();

			
			//Deletion of Record
			Query query = session.createQuery("delete from Employee where eno=100");

			int rowCount = query.executeUpdate();
			System.out.println(rowCount);

			if (rowCount == 1) {
				System.out.println("No of records deleted is :" + rowCount);
			} else {
				System.out.println("Record not found for deletion");
			}
			
			System.out.println();

			
			//Updating  a Record
			String HqlUpdateQuery = "update Employee as e set e.ename='sachinTendulkar',e.eage=48,e.eaddress='MUMBAIINDIANS' where e.eno=100";
			Query updateQuery = session.createQuery(HqlUpdateQuery);
			int updatedCount = updateQuery.executeUpdate();
			System.out.println("No of records Updated is :" + updatedCount);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.close();
			}
		}

	}

}
