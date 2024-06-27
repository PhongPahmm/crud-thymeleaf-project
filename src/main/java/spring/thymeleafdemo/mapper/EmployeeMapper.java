package spring.thymeleafdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import spring.thymeleafdemo.dto.request.EmployeeCreationRequest;
import spring.thymeleafdemo.dto.request.EmployeeUpdateRequest;
import spring.thymeleafdemo.dto.response.EmployeeResponse;
import spring.thymeleafdemo.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeCreationRequest request);
    EmployeeResponse toEmployeeResponse(Employee employee);
    void updateEmployee(@MappingTarget Employee employee, EmployeeUpdateRequest request);
}
