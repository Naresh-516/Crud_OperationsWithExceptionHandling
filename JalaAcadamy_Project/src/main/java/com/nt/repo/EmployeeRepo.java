package com.nt.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.Document.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
	 
}
