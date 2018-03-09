package tableModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity

public class UserTable {
	
	private long  phoneNumber;	//primaryKey
	
	//private int userId;	//foreginKey
	private String name;
	
	
	private String emailId; 		//uniqueKey
	private CartDetail cart;
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserID")
	public CartDetail getCart() {
		return cart;
	}
	public void setCart(CartDetail cart) {
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
	@Temporal(TemporalType.DATE)
	
	@Lob
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
