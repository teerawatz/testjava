package com.example.testjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testjava.model.Employee;
import com.example.testjava.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            System.out.println("Number of employees retrieved: " + employees.size());
            System.out.println("List of Employees:");
            for (Employee employee : employees) {
                System.out.println("Name: " + employee.getName() + ", Designation: " + employee.getDesignation());
            }
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    //get an employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee;
    }

    //insert employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee entity) {
        Employee savedEntity = employeeRepository.save(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    //update employee by id
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee entity) {
        entity.setId(id);
        Employee savedEntity = employeeRepository.save(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.OK);
    }

    //delete employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEntity(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name")
    public List<Employee> getEntitiesByName(@RequestParam String name) {
        
        return employeeRepository.findByName(name);
    }
    
}
