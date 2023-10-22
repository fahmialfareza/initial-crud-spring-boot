package com.fahmialfareza.initialDemo.Repository;

import com.fahmialfareza.initialDemo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from public.employee", Integer.class);
    }

    @Override
    public int save(Employee employee) {
        return jdbcTemplate
                .update("insert into public.employee(lastname, firstname, address, city) values (?, ?, ?, ?)",
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getAddress(),
                        employee.getCity());
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate
                .update("update public.employee set lastname = ?, firstname = ?, address = ?, city = ? where employeeID = ?",
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getAddress(),
                        employee.getCity(),
                        employee.getEmployeeID());
    }

    @Override
    public int deleteByID(Long id) {
        return jdbcTemplate.update("delete from public.employee where employeeID = ?", id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from public.employee",
                (rs, rowNum) -> new Employee(
                        rs.getLong("employeeID"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("address"),
                        rs.getString("city")
                )
        );
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return jdbcTemplate.query("select * from public.employee where lastname like ?",
                (rs, rowNum) -> new Employee(
                        rs.getLong("employeeID"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("address"),
                        rs.getString("city")
                ),
                new Object[]{ "%" + lastName + "%"}
        );
    }

    @Override
    public Optional<Employee> findByID(Long id) {
        return jdbcTemplate.query("select * from public.employee where employeeID = ?",
                (rs, rowNum) -> new Employee(
                        rs.getLong("employeeID"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("address"),
                        rs.getString("city")
                ),
                id
        ).stream().findFirst();
    }
}
