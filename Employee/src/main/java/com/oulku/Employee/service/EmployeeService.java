package com.oulku.Employee.service;

import com.oulku.Employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee) throws Exception;

    List<Employee> findAll() throws Exception;

    Employee findById(int id) throws Exception;

    void delete(int id) throws Exception;

    List<Employee> findByName(String name) throws Exception;

    Employee getEmployee(int employeeId, String name) throws Exception;
}
