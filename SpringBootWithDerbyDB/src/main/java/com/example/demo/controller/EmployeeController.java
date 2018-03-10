package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/venutech")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// http://localhost:8777/venutech/emp/add
	@PostMapping("/emp/add")
	public String addEmployee(@RequestBody Employee employee) {
		Integer empID = employeeService.addEmployee(employee);
		return "Your empID : " + empID;
	}

	// http://localhost:8777/venutech/emp?empID=1
	@GetMapping("/emp")
	public Employee findEmployee(@RequestParam Integer empID) {
		Employee employee = employeeService.findEmployee(empID);
		return employee;
	}

	// http://localhost:8777/venutech/emp/all
	@GetMapping("/emp/all")
	public List<Employee> findAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();
		return employees;
	}

	// http://localhost:8777/venutech/emp?empID=1
	@DeleteMapping("/emp")
	public String deleteEmployee(@RequestParam Integer empID) {
		Integer employeeID = employeeService.deleteEmployee(empID);
		return "EmpId: "+employeeID + "delete successfully...";
	}

}
