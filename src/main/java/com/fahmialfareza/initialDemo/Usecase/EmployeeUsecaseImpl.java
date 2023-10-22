package com.fahmialfareza.initialDemo.Usecase;

import com.fahmialfareza.initialDemo.Entity.Employee;
import com.fahmialfareza.initialDemo.Repository.EmployeeRepository;
import com.fahmialfareza.initialDemo.Repository.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeUsecaseImpl implements EmployeeUsecase {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public int count() {
        return employeeRepository.count();
    }

    @Override
    public int save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public int update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public int deleteByID(Long id) {
        return employeeRepository.deleteByID(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    public Optional<Employee> findByID(Long id) {
        return employeeRepository.findByID(id);
    }


}
