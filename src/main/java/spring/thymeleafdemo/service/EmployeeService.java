package spring.thymeleafdemo.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import spring.thymeleafdemo.dto.request.EmployeeCreationRequest;
import spring.thymeleafdemo.dto.request.EmployeeUpdateRequest;
import spring.thymeleafdemo.dto.response.EmployeeResponse;
import spring.thymeleafdemo.entity.Employee;
import spring.thymeleafdemo.mapper.EmployeeMapper;
import spring.thymeleafdemo.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService {
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    public EmployeeResponse createEmployee(EmployeeCreationRequest request) {
        Employee employee = employeeMapper.toEmployee(request);
        return employeeMapper.toEmployeeResponse(employeeRepository.save(employee));
    }

    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper :: toEmployeeResponse).toList();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public EmployeeResponse updateEmployee(int id, EmployeeUpdateRequest request) {
        Employee employee = employeeRepository.findById(id).orElseThrow(RuntimeException::new);
        employeeMapper.updateEmployee(employee, request);
        return employeeMapper.toEmployeeResponse(employee);
    }

    public void saveEmployee(Employee employee) {
        employeeMapper.toEmployeeResponse(employeeRepository.save(employee));
    }
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
