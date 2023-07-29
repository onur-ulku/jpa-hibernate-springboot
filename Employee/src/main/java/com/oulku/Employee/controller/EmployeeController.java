package com.oulku.Employee.controller;

import com.oulku.Employee.model.Employee;
import com.oulku.Employee.model.dto.ExampleDTO;
import com.oulku.Employee.service.CustomService;
import com.oulku.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CustomService customService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CustomService customService) {
        this.employeeService = employeeService;
        this.customService = customService;
    }

    @PostMapping("/employee")
    public void save(@RequestBody Employee employee) throws Exception {
        employeeService.save(employee);
    }

    @GetMapping("/employee")
    public List<Employee> get() throws Exception {
        return employeeService.findAll();
    }

    @PutMapping("/employee")
    public void update(@RequestBody Employee employee) throws Exception {
        employeeService.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable int id) throws Exception {
        employeeService.delete(id);
    }

    @GetMapping("/employee/getById/{id}")
    public Employee get(@PathVariable int id) throws Exception {
        Employee employee = employeeService.findById(id);
        return employee;
    }

    @GetMapping("/employee/getByName/{name}")
    public List<Employee> getByName(@PathVariable String name) throws Exception {
        List<Employee> employeeList=employeeService.findByName(name);
        return employeeList;
    }

    @GetMapping(path = "/employee/getEmployee/{id}/{name}")
    public Employee getEmployee(@PathVariable int id, @PathVariable String name) throws Exception {
        Employee employee = employeeService.getEmployee(id,name);
        return employee;
    }

    @GetMapping(path = "/employee/getTypedQueryByIdAndName/{id}/{name}")
    public ExampleDTO getTypedQuery(@PathVariable int id, @PathVariable String name) throws Exception {
        ExampleDTO exampleDTO = customService.getExampleDTOByIdAndName(id,name);
        return exampleDTO;
    }
}
