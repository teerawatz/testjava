package com.example.testjava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testjava.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom queries here if needed
    Optional<Employee> findById(Long id);
}
