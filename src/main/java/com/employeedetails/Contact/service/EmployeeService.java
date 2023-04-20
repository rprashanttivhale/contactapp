package com.employeedetails.Contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedetails.Contact.model.Employee;
import com.employeedetails.Contact.repository.EmployeeRepository;
import com.employeedetails.Contact.request.EmployeeRequest;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(EmployeeRequest employeeRequest) {

		Employee emp = new Employee();

		if (employeeRequest.getFirstName() != null)
			emp.setFirstName(employeeRequest.getFirstName());
		if (employeeRequest.getLastName() != null)
			emp.setLastName(employeeRequest.getLastName());
		if (employeeRequest.getEmail() != null)
			emp.setEmail(employeeRequest.getEmail());
		if (employeeRequest.getAge() != null)
			emp.setAge(employeeRequest.getAge());

		Employee e = employeeRepository.save(emp);

		return e;
	}

	public Employee updateEmployee(EmployeeRequest employeeRequest) {
		Employee emp = new Employee();
		Employee e = null ;
		Boolean isEmployeePresent = employeeRepository.existsById(employeeRequest.getId());
		
		if(isEmployeePresent) {
			emp = employeeRepository.getById(employeeRequest.getId());
			
			if (employeeRequest.getFirstName() != null)
				emp.setFirstName(employeeRequest.getFirstName());
			if (employeeRequest.getLastName() != null)
				emp.setLastName(employeeRequest.getLastName());
			if (employeeRequest.getEmail() != null)
				emp.setEmail(employeeRequest.getEmail());
			if (employeeRequest.getAge() != null)
				emp.setAge(employeeRequest.getAge());

			  e = employeeRepository.save(emp);
			
		}

		

		return e;
	}

	public List<Employee> getAllEmployee() {
		
	
		List<Employee> emps = employeeRepository.findAll();
		 
		return emps;
	}

	public void deleteEmployeeById(Long id) {
		Boolean isEmployeePresent = employeeRepository.existsById(id);
		if(isEmployeePresent) {
			employeeRepository.deleteById(id);
		}
		 
	}

}
