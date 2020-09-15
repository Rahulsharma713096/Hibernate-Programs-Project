package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;

import com.rahul.factory.HibernateUtil;

public class ReadOperation {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession();) {

			List<Object[]> employee = session
					.createSQLQuery("select `ENO`,`ENAME`,`EAGE` from `EMPLOYEE` where `ENO`=1")
					.getResultList();

			System.out.println("ENO\tENAME\tEAGE");

			for (Object[] emp : employee) {
				System.out.println(emp[0] + "\t" + emp[1] + "\t" + emp[2]);
			}
			System.out.println("---------------------------------------------------------------");
			List<Object[]> employee1 = session
					.createSQLQuery("select `ENO`,`ENAME`,`EAGE` from `EMPLOYEE1` where `ENO`=7")
					.getResultList();

			System.out.println("ENO\tENAME\tEAGE");

			for (Object[] emp : employee1) {
				System.out.println(emp[0] + "\t" + emp[1] + "\t" + emp[2]);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
