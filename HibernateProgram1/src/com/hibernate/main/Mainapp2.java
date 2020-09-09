package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.Employee;

public class Mainapp2 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory bfs = cfg.buildSessionFactory();

		Session os = bfs.openSession();

		Transaction transaction = os.beginTransaction();
	
		Employee e = new Employee();

		e.setEno(4); e.setEname("RAHUL"); e.setEage(18); e.setEaddress("abc");
		os.save(e);
		transaction.commit();
		System.out.println("Employee details got save in database :"+e.getEno());
		bfs.close();
}
}

