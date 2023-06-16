package net.texala.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import net.texala.constants.Utility;
import net.texala.enums.Status;
import net.texala.exception.ServiceException;
import net.texala.model.Employee;
import net.texala.repository.EmployeeRepository;
import net.texala.service.EmployeeService;
import net.texala.specification.SearchSpecification;
import net.texala.web.mapper.EmployeeMapper;
import net.texala.web.vo.EmployeeVo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Page<EmployeeVo> search(Integer pageNo, Integer pageSize, String sortBy, String filterBy,
			String searchText) {
		final Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Utility.sortByValues(sortBy)));
		final Specification<Employee> specification = SearchSpecification.searchEmployee(filterBy, searchText);
		return repo.findAll(specification, pageable).map(employeeMapper::toVo);
	}

	@Override
	public List<EmployeeVo> fetchAll() {
		return employeeMapper.toVos(repo.findAll());
	}

	@Override
	public EmployeeVo fetchById(Long id) {
		return employeeMapper.toVo(findById(id));
	}

	private Employee findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ServiceException("Empoyee ID not present"));
	}

	@Override
	@Transactional
	public EmployeeVo add(EmployeeVo employeeVo) {
		Employee employee = employeeMapper.toEntity(employeeVo);
		return employeeMapper.toVo(repo.save(employee));
	}

	@Override
	@Transactional
	public EmployeeVo update(EmployeeVo employeeVo) {
		Objects.requireNonNull(employeeMapper.toEntity(employeeVo));
		Optional<Employee> optionalEmployee = repo.findById(employeeVo.getId());
		if (optionalEmployee.isPresent()) {
			Employee employee = employeeMapper.toEntity(employeeVo);
			return employeeMapper.toVo(repo.save(employee));
		} else {
			throw new ServiceException("Employee with ID " + employeeVo.getId() + " not found");
		}
	}

	@Override
	@Transactional
	public void update(long id, Status status) {
		repo.updateStatus(id, status);

	}

	@Override
	public void delete(long id) {
		findById(id);
		repo.deleteById(id);

	}

}
