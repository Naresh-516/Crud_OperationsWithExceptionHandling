package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Document.Employee;
import com.nt.service.IEmployeeService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/employee-api")
public class EmployeeController {

    @Autowired
    private IEmployeeService serv;

    @PostMapping("/addemployee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) {
        Employee savedEmp = serv.saveEmployee(emp);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable int id) {
        Employee emp = serv.getEmployee(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    @PutMapping("/updateEmployeeinfo")
    public ResponseEntity<Employee> updateEmployeeInfo(@RequestParam int id,@RequestParam String address,@RequestParam String city,@RequestParam String country){
    	
    	return new ResponseEntity<Employee>(serv.updateEmployee(id, address, city, country),HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> deleteEmployeebyID(@PathVariable int id) {
        return new ResponseEntity<>(serv.deleteEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(serv.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/allEmployeesPage")
    public ResponseEntity<Page<Employee>> getAllEmployeespagination(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(serv.getEmployeesWithPagination(page, size), HttpStatus.OK);
    }

    @GetMapping("/allEmployeesSort")
    public ResponseEntity<Page<Employee>> getAllEmployeesbysorting(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortby,
            @RequestParam String direction) {
        return new ResponseEntity<>(serv.getEmployeesWithPageandSort(page, size, sortby, direction), HttpStatus.OK);
    }
}
