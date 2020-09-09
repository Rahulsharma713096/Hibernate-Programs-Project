package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.Employee;

public class MainApp {
	public static void main(String[] args) {
Configuration cfg = new Configuration();
cfg.configure();

SessionFactory bfs = cfg.buildSessionFactory();

Session os = bfs.openSession();

Transaction transaction = os.getTransaction();
transaction.begin();
Employee e = new Employee();

e.setEno(2); e.setEname("RAHUL"); e.setEage(18); e.setEaddress("abc");
os.save(e);
transaction.commit();
System.out.println("Employee details got save in database :"+e.getEno());
bfs.close();
}
}
