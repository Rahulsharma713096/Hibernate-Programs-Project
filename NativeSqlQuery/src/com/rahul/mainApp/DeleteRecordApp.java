package com.rahul.mainApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.factory.HibernateUtil;

public class DeleteRecordApp {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			Transaction transaction = session.beginTransaction();

			try {
				int rowCount = session.createSQLQuery("delete from EMPLOYEE where `ENO`=:eno").setParameter("eno", "10")
						.executeUpdate();
				transaction.commit();

				if (rowCount == 1) {
					System.out.println("Record got deleted");
				} else {
					System.out.println("Failed to delete the record");
				}
				
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
