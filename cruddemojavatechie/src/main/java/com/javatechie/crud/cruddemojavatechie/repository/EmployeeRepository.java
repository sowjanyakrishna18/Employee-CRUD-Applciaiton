package com.javatechie.crud.cruddemojavatechie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.crud.cruddemojavatechie.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
