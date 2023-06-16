//package net.texala.repository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import net.texala.model.Employee;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@AutoConfigureTestDatabase(replace = Replace.NONE) // Specify the replace strategy for the data source
//public class EmployeeRepositoryTests {
//
//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	// Junit test for saveEmployee
//
//	@Test
//	public void saveEmployeeTest() {
//
//		Employee employee = Employee.builder()
//				// .id(101l)
//				.firstName("Test1").lastName("Test1").address("Test1").salary(4580.0f).build();
//
//		employeeRepository.save(employee);
//
//		Assertions.assertThat(employee.getId()).isGreaterThan(0);
//	}
//
//	@Test
//	public void getEmployeeTest() {
//		Employee employee = employeeRepository.findById(3502l).get();
//
//		Assertions.assertThat(employee.getId()).isEqualTo(3502l);
//	}
//}
