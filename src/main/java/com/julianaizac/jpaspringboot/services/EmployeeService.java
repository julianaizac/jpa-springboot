package com.julianaizac.jpaspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.julianaizac.jpaspringboot.DTO.EmployeeDTO;
import com.julianaizac.jpaspringboot.DTO.EmployeeInsertDTO;
import com.julianaizac.jpaspringboot.DTO.EmployeeUpdateDTO;
import com.julianaizac.jpaspringboot.entities.Employee;
import com.julianaizac.jpaspringboot.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return toDTOList(employeeList);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> op = employeeRepository.findById(id);
        Employee employee = op
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return new EmployeeDTO(employee);
    }
    
    public EmployeeDTO insert(EmployeeInsertDTO dto) {
        Employee entity = new Employee(dto);
        entity = employeeRepository.save(entity);
        return new EmployeeDTO(entity);
    }

    public void delete(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    public EmployeeDTO update(Long id, EmployeeUpdateDTO dto) {
        try {
            Employee entity = employeeRepository.getOne(id);
            entity.setName(dto.getName());
            entity.setSalary(dto.getSalary());
            entity = employeeRepository.save(entity);
            return new EmployeeDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }
    
    public List<EmployeeDTO> toDTOList(List<Employee> employeeList) {
        List<EmployeeDTO> employeeListDTO = new ArrayList<>();

        for (Employee e : employeeList) {
            EmployeeDTO dto = new EmployeeDTO(e.getId(), e.getName(), e.getSalary());
            employeeListDTO.add(dto);
        }

        return employeeListDTO;
    }

}
