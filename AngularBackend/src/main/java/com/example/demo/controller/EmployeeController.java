package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionHandler.CustomException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getAllEmployees(@PathVariable long id) throws Exception{
		 Employee emp=employeeRepo.findById(id).orElseThrow(()-> new Exception("Employee not found"));
		 return ResponseEntity.ok().body(emp);
		 
	}
	
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		/*Employee emp=null;
		try {
		emp=employeeRepo.save(employee);
		
		
		}
		catch (CustomException e) {*/
			throw new CustomException("Internal Error");
			/*
			 * } return new ResponseEntity<Employee>(emp, HttpStatus.OK);
			 */
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) throws NumberFormatException, Exception{
		
		Employee emp=employeeRepo.findById(Long.valueOf(id)).orElseThrow(()-> new Exception("Employee not found"));
		emp.setId(employee.getId());
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		final Employee upadtedEmployee=employeeRepo.save(emp);
		return ResponseEntity.ok().body(upadtedEmployee);
		
	}
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable String id) throws NumberFormatException, Exception
	{
		Employee emp=employeeRepo.findById(Long.valueOf(id)).orElseThrow(()-> new Exception("Employee not found"));
		employeeRepo.delete(emp);
		Map<String, Boolean> response= new HashMap<String, Boolean>();
		response.put("Deleted", true);
		return response;
	}
}
