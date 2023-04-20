package com.employeedetails.Contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedetails.Contact.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
