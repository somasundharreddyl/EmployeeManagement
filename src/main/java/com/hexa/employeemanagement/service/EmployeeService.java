package com.hexa.employeemanagement.service;

import java.util.List;

import com.hexa.employeemanagement.dto.EmployeeRequestDto;
import com.hexa.employeemanagement.dto.EmployeeResponseDto;


public interface EmployeeService {

	public Long createEmployee(EmployeeRequestDto employee);
	
	public EmployeeResponseDto findEmployeeById(Long id);
	
	public EmployeeResponseDto updateEmployee(EmployeeResponseDto employee);
	
	public String deleteEmployeeById(Long id);

	public List<EmployeeResponseDto> getEmployeeList();
	
}
