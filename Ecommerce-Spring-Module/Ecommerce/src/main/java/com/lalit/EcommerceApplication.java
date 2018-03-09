package com.lalit;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tableModel.CartDetail;
import tableModel.UserTable;


@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		
		
		UserTable obj=new UserTable();
		CartDetail cart=new CartDetail();
		
		
	
		obj.setEmailId("abdwss@gmail.com");
		obj.setName("Rohit");
		obj.setPassword("Lali12345");
		obj.setPhoneNumber(853);
		obj.setCart(cart);
		
		Session session;
		SessionFactory sessionFactory;
	
			sessionFactory=new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			session.close();
			
			
			//open new session to fetch data from database
			obj=null;

			
			session = sessionFactory.openSession();  // this is used to start the new session
			session.beginTransaction();				//here we start the new transaction with new session
			obj=(UserTable) session.get(UserTable.class,(long)853);		//this is use to get data from the data base
			
			System.out.println("User name Retrieved  " + obj.getEmailId());
					
	}
}
