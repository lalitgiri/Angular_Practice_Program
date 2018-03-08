package com.lalit;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tableModel.Cart_Detail;
import tableModel.User_Table;


@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		
		
		User_Table obj=new User_Table();
		Cart_Detail cart=new Cart_Detail();
		
		
	
		obj.setEmailId("ab@gmail.com");
		obj.setName("Lalit ");
		obj.setPassword("Lali12345");
		obj.setPhoneNumber(8576);
		obj.setCart(cart);
		
		Session session;
		try {
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
