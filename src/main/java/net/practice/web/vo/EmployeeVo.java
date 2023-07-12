package net.practice.web.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import net.practice.enums.Status;

//@Data
public class EmployeeVo {
	// @Nullable
	private long id = 0L;

	@NotBlank(message = "First name is required")
//	@Size(min = 2, max = 50, message = "First name must be between {min} and {max} characters")
	private String firstName;

	@NotBlank(message = "Last name is required")
//	@Size(min = 2, max = 50, message = "Last name must be between {min} and {max} characters")
	private String lastName;

	@NotBlank(message = "Address is required")
//	@Size(min = 3, max = 100, message = "Address must be between {min} and {max} characters")
	private String address;

//	@Size(min = 1, max = 100000, message = "Salary must be a positive number")
//	@DecimalMin(value = "0.0")
//	@DecimalMax(value = "10000.0")
	private Float salary;

	@NotNull(message = "Status is required")
	private Status status;

	
	
	public EmployeeVo() {

	}

	public EmployeeVo(long id, @NotBlank(message = "First name is required") String firstName,
			@NotBlank(message = "Last name is required") String lastName,
			@NotBlank(message = "Address is required") String address, Float salary,
			@NotNull(message = "Status is required") Status status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.salary = salary;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
