package com.example.testjava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String designation;

    // Getters and setters

     // Constructor without parameters
     public Employee() {
    }

    // Constructor with name and designation parameters
    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for designation
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Additional method to update name
    public void updateName(String newName) {
        this.name = newName;
    }

    // Additional method to update designation
    public void updateDesignation(String newDesignation) {
        this.designation = newDesignation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
