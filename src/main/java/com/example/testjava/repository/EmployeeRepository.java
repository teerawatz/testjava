package com.example.testjava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.testjava.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom queries here if needed
    @Query("SELECT e FROM Employee AS e WHERE e.name LIKE %:name%")
    List<Employee> findByName(@Param("name") String name);
    
}
