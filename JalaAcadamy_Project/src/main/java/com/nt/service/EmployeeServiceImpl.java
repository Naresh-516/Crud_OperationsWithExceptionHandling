package com.nt.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.Document.Employee;
import com.nt.exception.UserNotFoundException;
import com.nt.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee saveEmployee(Employee emp) {
		
		return repo.save(emp);
	}

	@Override
	public Employee getEmployee(int id) {
		
		return repo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repo.findAll();
	}

	@Override
	public String deleteEmployee(int id) {
		
		repo.deleteById(id);
		return "Employee Deleted";
	}

	@Override
	public Page<Employee> getEmployeesWithPagination(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    return repo.findAll(pageable);
	}

	@Override
	public Page<Employee> getEmployeesWithPageandSort(int page, int size, String sortBy, String direction) {
	    Sort sort = direction != null && direction.equalsIgnoreCase("asc")
	                ? Sort.by(sortBy).ascending()
	                : Sort.by(sortBy).descending();

	    Pageable pageable = PageRequest.of(page, size, sort);
	    return repo.findAll(pageable);
	}

	@Override
	public Employee updateEmployee(int id,String email,Long number) {
	    Employee emp = repo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
	    emp.setEmail(email);
	    emp.setMobileNumber(number);
	    return repo.save(emp);
	}



}
