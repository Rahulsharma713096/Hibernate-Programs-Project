package com.rahul.mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.rahul.factory.HibernateUtil;

public class ArithmeticExpressionApp {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			String hqlSelectQuery = "select (e.eage-5)from Employee as e";
			Query query = session.createQuery(hqlSelectQuery);
			List<Integer> employees = query.getResultList();

			for (Integer data : employees) {

				System.out.println(data);
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
