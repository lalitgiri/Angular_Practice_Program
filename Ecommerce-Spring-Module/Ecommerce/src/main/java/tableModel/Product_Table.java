package tableModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product_Table {


	private int productId;    		//primaryKey
	private String productName;
	private String productCategory;
	private int productQuantity;
	private String productPrice;
	private byte[] description;
	private String imageUrl;
	private Employee_Detail employeeId; 			//foreginKey
	
	@Id
	@GeneratedValue
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public byte[] getDescription() {
		return description;
	}
	public void setDescription(byte[] description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserID")
	public Employee_Detail getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee_Detail employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
