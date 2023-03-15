package com.javatechie.crud.cruddemojavatechie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.cruddemojavatechie.exception.ResourceNotFound;
import com.javatechie.crud.cruddemojavatechie.model.Employee;
import com.javatechie.crud.cruddemojavatechie.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updatEmployee(Employee employee, int i) {
		// TODO Auto-generated method stub
		Optional<Employee> Employeeupdate= this.employeeRepository.findById(i);
		if(Employeeupdate.isPresent())
		{
			Employee employeeobject=Employeeupdate.get();
			//employeeobject.setId(employee.getId());
			employeeobject.setName(employee.getName());
			employeeobject.setEmail(employee.getEmail());
			employeeRepository.save(employeeobject);
			return employeeobject;
		}
		else
			throw new ResourceNotFound("employee id is not available");
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeobject=employeeRepository.findById(id);
		if(employeeobject.isPresent())
			return employeeobject.get();
		else
			throw new ResourceNotFound("employee id is not available");
			
	}

	@Override
	public void deleteById(int id) {
		Optional<Employee> Employeedelete= this.employeeRepository.findById(id);
		
		if(Employeedelete.isPresent())
			this.employeeRepository.delete(Employeedelete.get());
		else
			throw new ResourceNotFound("employee id is not available");
		
	}

}
