package com.julianaizac.jpaspringboot.controllers;

import java.util.List;

import com.julianaizac.jpaspringboot.DTO.EmployeeDTO;
import com.julianaizac.jpaspringboot.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployee() {
        List<EmployeeDTO> employeeListDTO = employeeService.getEmployees();
        return ResponseEntity.ok(employeeListDTO);
    }

}
