package com.example.restcrudproject.service;

import com.example.restcrudproject.exception.ResourceNotFoundException;
import com.example.restcrudproject.model.Employee;
import com.example.restcrudproject.respository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return (Employee)this.employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id) {
        return (Employee)this.employeeRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Employee", "Id", id);
        });
    }

    public Employee updateEmployee(Employee employee, long id) {
        Employee validEmployee = (Employee)this.employeeRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Employee", "Id", id);
        });
        validEmployee.setFirstName(employee.getFirstName());
        validEmployee.setLastName(employee.getLastName());
        validEmployee.setEmail(employee.getEmail());
        this.employeeRepository.save(validEmployee);
        return validEmployee;
    }

    public void deleteEmployee(long id) {
        Employee var10000 = (Employee)this.employeeRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Employee", "Id", id);
        });
        this.employeeRepository.deleteById(id);
    }
}
