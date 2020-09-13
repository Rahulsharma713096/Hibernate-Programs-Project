package com.rahul.mainApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rahul.factory.HibernateUtil;

@SuppressWarnings("deprecation")
public class CombinationParameterApp {
	// This Code Only supports Hibernate4.X
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Session session = null;
		Scanner scanner = null;
		try {

			session = HibernateUtil.getSession();

			scanner = new Scanner(System.in);
			System.out.print("Enter the value of eid: ");

			int eno = scanner.nextInt();

			System.out.print("Enter the value of eage: ");

			int eage = scanner.nextInt();

			String hqlSelectQuery = "select e.eno,e.ename,e.eage from Employee as e where e.eno=? and e.eage=:eage";
			Query query = session.createQuery(hqlSelectQuery);
			query.setParameter(0, eno);
			query.setParameter("eage", eage);

			List<Object[]> employeeList = query.list();

			if (!employeeList.isEmpty()) {
				System.out.println("ENO\tENAME\tESALARY");
				for (Object[] employees : employeeList) {
					for (Object employee : employees) {
						System.out.print(employee + "\t");
					}
					System.out.println();
				}
			} else {
				System.out.println("No record found for : " + eno);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {

				HibernateUtil.close();
				scanner.close();
			}
		}

	}

}
