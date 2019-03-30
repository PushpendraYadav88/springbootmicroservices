package com.pusp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pusp.bean.Employee;

@RestController
public class EmployeeController {

	private static Map<Integer, Employee> employeeData = null;
	static {
		 employeeData = new HashMap<Integer,Employee>();
		 employeeData.put(111,new Employee(111,"Employee1"));
		 employeeData.put(222,new Employee(222,"Employee2"));
	}
	
	@GetMapping(value = "/findEmployeeDetails/{id}")
	public Employee getEmployeeDetails(@PathVariable int id) {
		Employee employee = employeeData.get(id);
		if(employee == null) {
			return new Employee(0,"N/A");
		}
		return employee;
	}
}
