

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.dao.UserDetails;

public class PopulateData {
	
	/*UserDetails obj=new UserDetails();
	CartDetails cart=new CartDetails();
	UserDetails obj1=new UserDetails();
	CartDetails cart1=new CartDetails();
	UserDetails obj2=new UserDetails();
	CartDetails cart2=new CartDetails();
	UserDetails obj3=new UserDetails();
	CartDetails cart3=new CartDetails();
	UserDetails obj4=new UserDetails();
	CartDetails cart4=new CartDetails();
	
    void populateData(){
	obj.setEmailId("abdwss@gmail.com");
	obj.setName("Rohit");
	obj.setPassword("Lali12345");
	obj.setPhoneNumber(853);
	obj.setCart(cart);
	
	obj1.setEmailId("1@gmail.com");
	obj1.setName("2t");
	obj1.setPassword("L223ali12345");
	obj1.setPhoneNumber(1234);
	obj1.setCart(cart1);
	
	obj2.setEmailId("abdwss@gmail.com");
	obj2.setName("2Rohit");
	obj2.setPassword("2Lali12345");
	obj2.setPhoneNumber(2853);
	obj2.setCart(cart2);
	
	obj3.setEmailId("3abdwss@gmail.com");
	obj3.setName("3Rohit");
	obj3.setPassword("3Lali12345");
	obj3.setPhoneNumber(3853);
	obj3.setCart(cart3);
	
	obj4.setEmailId("4abdwss@gmail.com");
	obj4.setName("4Rohit");
	obj4.setPassword("4Lali12345");
	obj4.setPhoneNumber(4853);
	obj4.setCart(cart4);
	
	
	
		Session session;
		SessionFactory sessionFactory;

		sessionFactory=new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(obj);
		session.save(obj1);
		session.save(obj2);
		session.save(obj3);
		session.save(obj4);
		session.getTransaction().commit();
		session.close();
		
		
		//open new session to fetch data from database
		obj=null;

		
		session = sessionFactory.openSession();  // this is used to start the new session
		session.beginTransaction();				//here we start the new transaction with new session
		obj=(UserDetails) session.get(UserDetails.class,(long)853);		//this is use to get data from the data base
		
		System.out.println("User name Retrieved  " + obj.getEmailId());
		}*/

}
