package tableModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class OrderDetails {

	@Id
	private int orderId;  //primaryKey
	private int userId;   //foreginKey
	private String  address;
	private byte[] itemDetail;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
