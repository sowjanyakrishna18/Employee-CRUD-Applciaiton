package com.javatechie.crud.cruddemojavatechie.service;

import java.util.List;

import com.javatechie.crud.cruddemojavatechie.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	Employee updatEmployee(Employee employee, int i);
	List<Employee> getAllEmployee();
	Employee getProductById(int id);
	void deleteById(int id);
}
