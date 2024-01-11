package com.example.testjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testjava.model.Employee;
import com.example.testjava.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

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

    // New endpoint to get an employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee;
    }
}
