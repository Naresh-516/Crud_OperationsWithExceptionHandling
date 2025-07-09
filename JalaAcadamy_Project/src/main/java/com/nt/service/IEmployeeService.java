package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.Document.Employee;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee emp);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployees();
	public String deleteEmployee(int id);
	
	
	public Page<Employee> getEmployeesWithPagination(int page,int size);
	public Page<Employee> getEmployeesWithPageandSort(int page,int size,String sortby,String direction);
	Employee updateEmployee(int id,Long mobile,String email);
	
}
