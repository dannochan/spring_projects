package com.example.restcrudproject.controller;

import com.example.restcrudproject.model.Employee;
import com.example.restcrudproject.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/mapping"})
public class EmployeeController {


        private final EmployeeServiceImpl employeeService;

        public EmployeeController(EmployeeServiceImpl employeeService) {
            this.employeeService = employeeService;
        }

        @PostMapping
        public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
            return new ResponseEntity(this.employeeService.saveEmployee(employee), HttpStatus.CREATED);
        }

        @GetMapping
        public List<Employee> getAllEmployee() {
            return this.employeeService.getAllEmployee();
        }

        @GetMapping({"{id}"})
        public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
            return new ResponseEntity(this.employeeService.getEmployeeById(employeeId), HttpStatus.OK);
        }

        @PostMapping({"{id}"})
        public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
            return new ResponseEntity(this.employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
        }

        @DeleteMapping({"{id}"})
        public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
            this.employeeService.deleteEmployee(id);
            return new ResponseEntity("Employee deleted successfully!", HttpStatus.OK);
        }

}
