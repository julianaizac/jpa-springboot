package com.julianaizac.jpaspringboot.repositories;

import com.julianaizac.jpaspringboot.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

}
