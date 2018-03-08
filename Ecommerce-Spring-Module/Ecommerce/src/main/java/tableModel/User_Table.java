package tableModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class User_Table {
	
	private long  phoneNumber;	//primaryKey
	
	//private int userId;	//foreginKey
	private String name;
	private String emailId; 		//uniqueKey
	private Cart_Detail cart;
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(
			name="USER_CART",
			joinColumns= {@JoinColumn(name="UserID")},
			inverseJoinColumns = {@JoinColumn(name="phoneNumber")}
		)
	public Cart_Detail getCart() {
		return cart;
	}
	public void setCart(Cart_Detail cart) {
		this.cart = cart;
	}
	
		
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Id
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
