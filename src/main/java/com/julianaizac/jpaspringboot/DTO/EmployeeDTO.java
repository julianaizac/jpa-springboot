package com.julianaizac.jpaspringboot.DTO;

import com.julianaizac.jpaspringboot.entities.Employee;

public class EmployeeDTO {
    private Long id;
    private String name;
    private Double salary;

    public EmployeeDTO(){
        
    }

    public EmployeeDTO(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.salary = employee.getSalary();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
 
}
