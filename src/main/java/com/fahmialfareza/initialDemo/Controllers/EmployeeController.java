package com.fahmialfareza.initialDemo.Controllers;

import com.fahmialfareza.initialDemo.Entity.Employee;
import com.fahmialfareza.initialDemo.Usecase.EmployeeUsecaseImpl;
import com.fahmialfareza.initialDemo.Usecase.EmployeeUsecase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeUsecase employeeUsecase;

    @GetMapping("/employees/count")
    public int employeeCount() {
        return employeeUsecase.count();
    }

    @PostMapping("/employees")
    public int addEmployee(@Valid @RequestBody Employee employee) {
        return employeeUsecase.save(employee);
    }

    @PutMapping("/employees/{id}")
    public int updateEmployee(@Valid @RequestBody Employee employee, @PathVariable(name = "id") Long id) {
        employee.setEmployeeID(id);

        return employeeUsecase.update(employee);
    }

    @DeleteMapping("/employees/{id}")
    public int deleteEmployee(@PathVariable(name = "id") long id) {
        return employeeUsecase.deleteByID(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeUsecase.findAll();
    }

    @GetMapping("/employees/find-by-last-name/{name}")
    public List<Employee> fingByLastName(@PathVariable(name = "name") String name) {
        return employeeUsecase.findByLastName(name);
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findByID(@PathVariable(name = "id") Long id) {
        return employeeUsecase.findByID(id);
    }
}
