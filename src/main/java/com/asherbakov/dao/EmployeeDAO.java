package com.asherbakov.dao;

import com.asherbakov.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee) throws SQLException;

    Employee getEmployeeById(Long id) throws SQLException;

    List<Employee> getAllEmployee() throws SQLException;

    void changeEmployee(Employee employee) throws SQLException;

    void removeEmployee(Employee employee) throws SQLException;
}
