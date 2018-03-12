package tableModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class OrderDetails {

	@Id
	private int orderId;  //primaryKey
	
	private String  address;
	private byte[] itemDetail;
	@ManyToOne
	private UserTable userId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserTable getUserId() {
		return userId;
	}
	public void setUserId(UserTable userId) {
		this.userId = userId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte[] getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(byte[] itemDetail) {
		this.itemDetail = itemDetail;
	}
	
	
}
