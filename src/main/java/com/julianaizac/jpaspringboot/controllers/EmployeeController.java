package com.julianaizac.jpaspringboot.controllers;

import java.net.URI;
import java.util.List;

import com.julianaizac.jpaspringboot.DTO.EmployeeDTO;
import com.julianaizac.jpaspringboot.DTO.EmployeeInsertDTO;
import com.julianaizac.jpaspringboot.DTO.EmployeeUpdateDTO;
import com.julianaizac.jpaspringboot.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        List<EmployeeDTO> employeeListDTO = employeeService.getEmployees();
        return ResponseEntity.ok(employeeListDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeInsertDTO insertDTO) {
        EmployeeDTO dto = employeeService.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, 
                                              @RequestBody EmployeeUpdateDTO updateDTO) {
        EmployeeDTO dto = employeeService.update(id, updateDTO);
        return ResponseEntity.ok().body(dto);                                            
    }


}
