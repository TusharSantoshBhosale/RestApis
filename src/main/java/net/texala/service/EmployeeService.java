package net.texala.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.texala.enums.Status;
import net.texala.web.vo.EmployeeVo;

@Service
public interface EmployeeService {

	public Page<EmployeeVo> search(Integer pageNo, Integer pageSize, String sortBy, String filterBy, String searchText);

	public List<EmployeeVo> fetchAll();

	public EmployeeVo fetchById(Long id);

	public EmployeeVo add(EmployeeVo employeeVo);

	public EmployeeVo update(EmployeeVo employeeVo);

	public void update(long id, Status status);

	public void delete(long id);

}
