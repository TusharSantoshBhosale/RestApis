package net.texala.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import net.texala.model.Employee;
import net.texala.web.vo.EmployeeVo;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	public EmployeeVo toVo(Employee employee);

	public Employee toEntity(EmployeeVo vo);

	public List<EmployeeVo> toVos(List<Employee> list);

}
