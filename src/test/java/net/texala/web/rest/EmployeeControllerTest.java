package net.texala.web.rest;

import net.texala.service.EmployeeService;
import net.texala.web.vo.EmployeeVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	private EmployeeVo employeeVo;

	@BeforeEach
	public void setUp() {
		employeeVo = new EmployeeVo();
		employeeVo.setId(1L);
		employeeVo.setFirstName("John");
		employeeVo.setLastName("Doe");
		employeeVo.setAddress("123 Main St");
		employeeVo.setSalary(50000.0f);
	}

	@Test
	public void search_returnsPageOfEmployees() throws Exception {
		// Arrange
		Page<EmployeeVo> page = new org.springframework.data.domain.PageImpl<>(Collections.singletonList(employeeVo));
		when(employeeService.search(0, Integer.MAX_VALUE, "id:desc", null, null)).thenReturn(page);

		// Act
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/v0/employee/search").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		// Assert
		String content = result.getResponse().getContentAsString();
		String expected = "{\"data\":{\"content\":[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"address\":\"123 Main St\",\"salary\":50000.0}],\"pageable\":{\"sort\":{\"sorted\":true,\"unsorted\":false,\"empty\":false},\"pageSize\":2147483647,\"pageNumber\":0,\"offset\":0,\"paged\":true,\"unpaged\":false},\"totalElements\":1,\"totalPages\":1,\"last\":true,\"first\":true,\"numberOfElements\":1,\"size\":1},\"status\":{\"code\":\"200 OK\",\"message\":\"FETCH_RECORDS\",\"time\":\"2023-03-24T20:18:29.9655781Z\"}}";
		assert content.equals(expected);
	}
}
