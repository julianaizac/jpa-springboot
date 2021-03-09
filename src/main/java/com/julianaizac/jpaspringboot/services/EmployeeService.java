package com.julianaizac.jpaspringboot.services;

import java.util.ArrayList;
import java.util.List;

import com.julianaizac.jpaspringboot.DTO.EmployeeDTO;
import com.julianaizac.jpaspringboot.entities.Employee;
import com.julianaizac.jpaspringboot.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getEmployees() {
        
        List<Employee> employeeList = employeeRepository.getEmployees();
        List<EmployeeDTO> employeeListDTO = new ArrayList<>();

        for (Employee e : employeeList) {
            EmployeeDTO dto = new EmployeeDTO(e.getId(), e.getName(), e.getSalary());
            employeeListDTO.add(dto);
        }
        return employeeListDTO;
    }

}
