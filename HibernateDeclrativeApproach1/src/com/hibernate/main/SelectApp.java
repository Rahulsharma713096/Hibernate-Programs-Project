package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.factory.HibernateUtil;
import com.hibernate.pojo.Employee;

public class SelectApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Session session = HibernateUtil.getSession();
			System.out.println("Enter The Eno which you need to Acess:");
			int eno=sc.nextInt();
			if(session.get(Employee.class,eno)==null) System.out.println("The "+eno+" Data Not Present in Database"); 
			else {
				Employee e = session.get(Employee.class,eno);
				System.out.println("The data are:");
				System.out.println(e.getEno());
				System.out.println(e.getEname());
				System.out.println(e.getEaddress());
				System.out.println(e.getEage());
			}
		
		}finally {
			HibernateUtil.close();
			sc.close();
		}
}
}