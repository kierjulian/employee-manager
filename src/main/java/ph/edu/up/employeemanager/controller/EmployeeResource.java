package ph.edu.up.employeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ph.edu.up.employeemanager.model.Employee;
import ph.edu.up.employeemanager.service.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeResource {
	
	private final EmployeeService employeeService;

	@Autowired
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Employee>> retrieveAllEmployees() {
		List<Employee> employeeList = employeeService.findAllEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK); 
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> retrieveEmployeeById(@PathVariable("employeeId") Long id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK); 
	}
	
	@PostMapping("")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED); 
	}
	
	@PutMapping("")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee oldEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(oldEmployee, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}

}
