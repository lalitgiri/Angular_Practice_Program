import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.core.io.*;  
  
public class Test {
	public static void main(String[] args) {  
		Resource resource=new ClassPathResource("applicaionContext.xml");  
		BeanFactory factory=new XmlBeanFactory(resource);   
	     Student student=(Student)factory.getBean("studentbean");
	    
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicaionContext.xml");
	    Student student=(Student)context.getBean("studentbean"); */ 
	    student.displayInfo();  
	}  
}
