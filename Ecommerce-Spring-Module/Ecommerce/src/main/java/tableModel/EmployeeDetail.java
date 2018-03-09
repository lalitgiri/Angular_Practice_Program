package tableModel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetail {
	
	
	private int employeeId;		//primary Key
	private String employeeName;
	private String employeeRole;
	private long contactNumber;
	private String address;
	private boolean status;
	private Date joiningDate,resigningDate;
			
	@Id
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
