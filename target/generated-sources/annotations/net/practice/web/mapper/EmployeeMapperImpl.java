package net.practice.web.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import net.practice.model.Employee;
import net.practice.web.vo.EmployeeVo;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-12T11:12:57+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeVo toVo(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeVo employeeVo = new EmployeeVo();

        employeeVo.setAddress( employee.getAddress() );
        employeeVo.setFirstName( employee.getFirstName() );
        employeeVo.setId( employee.getId() );
        employeeVo.setLastName( employee.getLastName() );
        employeeVo.setSalary( employee.getSalary() );
        employeeVo.setStatus( employee.getStatus() );

        return employeeVo;
    }

    @Override
    public Employee toEntity(EmployeeVo vo) {
        if ( vo == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setAddress( vo.getAddress() );
        employee.setFirstName( vo.getFirstName() );
        employee.setId( vo.getId() );
        employee.setLastName( vo.getLastName() );
        if ( vo.getSalary() != null ) {
            employee.setSalary( vo.getSalary() );
        }
        employee.setStatus( vo.getStatus() );

        return employee;
    }

    @Override
    public List<EmployeeVo> toVos(List<Employee> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeVo> list1 = new ArrayList<EmployeeVo>( list.size() );
        for ( Employee employee : list ) {
            list1.add( toVo( employee ) );
        }

        return list1;
    }
}
