package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Integer addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp.getEmpID();
	}

	public Employee findEmployee(Integer empID) {
		Optional<Employee> emp = employeeRepository.findById(empID);
		return emp.get();
	}

	public List<Employee> findAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	public Integer deleteEmployee(Integer empID) {
		employeeRepository.deleteById(empID);
		return empID;
	}

}
