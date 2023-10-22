package com.fahmialfareza.initialDemo.Repository;

import com.fahmialfareza.initialDemo.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    int count();

    int save(Employee employee);

    int update(Employee employee);

    int deleteByID(Long id);

    List<Employee> findAll();

    List<Employee> findByLastName(String lastName);

    Optional<Employee> findByID(Long id);
}
