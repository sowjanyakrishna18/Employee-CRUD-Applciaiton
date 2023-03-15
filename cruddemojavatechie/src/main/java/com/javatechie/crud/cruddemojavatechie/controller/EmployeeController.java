package com.javatechie.crud.cruddemojavatechie.controller;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.cruddemojavatechie.model.Employee;
import com.javatechie.crud.cruddemojavatechie.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee>createEmployee(@RequestBody Employee employee)
	{
		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeebyID(@PathVariable("id") int id)
	{
		return ResponseEntity.ok().body(this.employeeService.getProductById(id));
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee e)
	{
		return ResponseEntity.ok().body(this.employeeService.updatEmployee(e, id));
	}
	
	@DeleteMapping("/employees/{id}")
	public HttpStatus deleteEmployee(@PathVariable("id") int id)
	{
		this.employeeService.deleteById(id);
		return HttpStatus.OK;
	}
	
}
