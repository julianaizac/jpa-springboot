package com.julianaizac.jpaspringboot.repositories;

import java.util.ArrayList;
import java.util.List;

import com.julianaizac.jpaspringboot.entities.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
    
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setId(1L);
        e1.setName("Mariana");
        e1.setAddress("Rua X, 99");
        e1.setSalary(2000.00);

        Employee e2 = new Employee();
        e2.setId(2L);
        e2.setName("Roberta");
        e2.setAddress("Rua Y, 88");
        e2.setSalary(3000.00);

        employeeList.add(e1);
        employeeList.add(e2);

        return employeeList;

    }

}
