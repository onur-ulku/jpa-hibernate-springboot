package com.oulku.Employee.service.impl;

import com.oulku.Employee.model.Employee;
import com.oulku.Employee.repository.EmployeeRepository;
import com.oulku.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) throws Exception {
        try {
            employeeRepository.save(employee);
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }
    }

    @Override
    public List<Employee> findAll() throws Exception {
        try {
            return employeeRepository.findAll();
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }

    }

    @Override
    public Employee findById(int id) throws Exception {
        try {
            Employee response;
            Optional<Employee> employee=employeeRepository.findById(id);
            if(employee.isPresent()){
                response = employee.get();
                return response;
            }else{
                throw new RuntimeException("Employee not found for the id: "+id);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }

    }

    @Override
    public void delete(int id) throws Exception {
        try {
            Employee employee = findById(id);
            if(employee!=null){
                employeeRepository.delete(employee);
            }else{
                throw new RuntimeException("Employee not found for the id: "+id);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }
    }

    public List<Employee> findByName(String name) throws Exception {
        try {
            List<Employee> employeeList = employeeRepository.findByName(name);
            if(employeeList != null){
                return employeeList;
            }else{
                throw new RuntimeException("Employee list not found for the name: "+name);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: "+ex.getMessage());
        }
    }

    public Employee getEmployee(int employeeId, String name) throws Exception {
        try {
            Employee employee = employeeRepository.getEmployee(employeeId,name);
            if(employee!=null){
                return employee;
            }else{
                throw new RuntimeException("Employee not found for the id: " + employeeId +" and name: "+name);
            }
        }catch (Exception ex){
            throw new Exception("Exception message: " + ex.getMessage());
        }
    }
}
