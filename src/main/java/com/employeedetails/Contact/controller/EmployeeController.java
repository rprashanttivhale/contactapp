package com.employeedetails.Contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeedetails.Contact.model.Employee;
import com.employeedetails.Contact.request.EmployeeRequest;
import com.employeedetails.Contact.service.EmployeeService;

//@RequestMapping("/api/contact")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
 

	@PostMapping("/employee/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest employeeRequest) {

		Employee employee = employeeService.addEmployee(employeeRequest);

		return ResponseEntity.ok(employee);

	}
	
	@PostMapping("/employee/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
 

		Employee employee = employeeService.updateEmployee(employeeRequest);

		return ResponseEntity.ok(employee);

	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee( ) {

		List<Employee> employees = employeeService.getAllEmployee();

		return ResponseEntity.ok(employees);

	}
	
	@PostMapping("/employee/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
 
		employeeService.deleteEmployeeById(id);

		return ResponseEntity.ok("Record Delete sucessfuly");

	}
	
	
	
	
	
	
	
	


}
