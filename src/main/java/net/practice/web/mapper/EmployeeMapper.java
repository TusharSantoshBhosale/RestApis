package net.practice.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import net.practice.model.Employee;
import net.practice.web.vo.EmployeeVo;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	public EmployeeVo toVo(Employee employee);

	public Employee toEntity(EmployeeVo vo);

	public List<EmployeeVo> toVos(List<Employee> list);

}
