package com.oulku.Employee.service.impl;

import com.oulku.Employee.model.dto.ExampleDTO;
import com.oulku.Employee.repository.CustomRepository;
import com.oulku.Employee.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements CustomService {

    private final CustomRepository customRepository;
    @Autowired
    public CustomServiceImpl(CustomRepository customRepository) {
        this.customRepository = customRepository;
    }

    public ExampleDTO getExampleDTOByIdAndName(int employeeId, String name) throws Exception {
        try {
            ExampleDTO exampleDTO = customRepository.getExampleDTOByIdAndName(employeeId, name);
            if (exampleDTO != null) {
                return exampleDTO;
            } else {
                throw new RuntimeException("ExampleDTO not found for the id: " + employeeId + " and name: " + name);
            }
        } catch (Exception ex) {
            throw new Exception("Exception message: " + ex.getMessage());
        }

    }

}
