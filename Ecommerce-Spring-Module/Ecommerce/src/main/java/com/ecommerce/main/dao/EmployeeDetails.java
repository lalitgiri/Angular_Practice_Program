package com.ecommerce.main.dao;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.bytebuddy.implementation.bind.annotation.Default;

@Entity
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int employeeId;		//primary Key
	private String employeeName;
	private String employeeRole;
	private long contactNumber;
	private String address;
	private boolean status;
	private Date joiningDate,resigningDate;
	
	@OneToMany(mappedBy="employeeId")
	private Collection <ProductTable> productId;
	
	public Collection<ProductTable> getProductId() {
		return productId;
	}
	public void setProductId(Collection<ProductTable> productId) {
		this.productId = productId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getResigningDate() {
		return resigningDate;
	}
	public void setResigningDate(Date resigningDate) {
		this.resigningDate = resigningDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
