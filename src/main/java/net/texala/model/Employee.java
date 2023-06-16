package net.texala.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.texala.enums.Status;

@Getter
@Setter
@Entity
@Table(name = "employees_data")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "first_name", length = 25, nullable = true)
	private String firstName;

	@Column(name = "last_name", length = 25, nullable = true)
	private String lastName;

	@Column(name = "address", length = 50, nullable = true)
	private String address;

	@Column(name = "salary", length = 7, nullable = true)
	private float salary;

	@Column(name ="status", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

}