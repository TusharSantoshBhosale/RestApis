package net.texala.web.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import net.texala.enums.Status;

@Data
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

}
