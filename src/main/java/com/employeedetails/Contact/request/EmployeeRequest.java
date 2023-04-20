package com.employeedetails.Contact.request;

import lombok.Data;

@Data
public class EmployeeRequest {
	

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Integer age;

}
