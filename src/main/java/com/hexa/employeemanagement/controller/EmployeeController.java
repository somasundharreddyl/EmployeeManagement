package com.hexa.employeemanagement.controller;

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

import com.hexa.employeemanagement.dto.EmployeeRequestDto;
import com.hexa.employeemanagement.dto.EmployeeResponseDto;
import com.hexa.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<Long> addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
		Long id=employeeService.createEmployee(employeeRequestDto);
		return new ResponseEntity<>(id,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeResponseDto> updateEmployee(@RequestBody EmployeeResponseDto employeeResponseDto){
		EmployeeResponseDto updatedEmployee = employeeService.updateEmployee(employeeResponseDto);
		return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeResponseDto> findEmployeeById(@PathVariable("id") Long id){
		EmployeeResponseDto employeeResponseDto = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employeeResponseDto,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		String response=employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<EmployeeResponseDto>> getEmployeeList(){
		List<EmployeeResponseDto> employeeList=employeeService.getEmployeeList();
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}
}
