package com.oulku.Employee.service;

import com.oulku.Employee.model.dto.ExampleDTO;

public interface CustomService {
    ExampleDTO getExampleDTOByIdAndName(int employeeId, String name) throws Exception;
}
