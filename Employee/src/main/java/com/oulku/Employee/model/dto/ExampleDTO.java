package com.oulku.Employee.model.dto;

public class ExampleDTO {
    private int employeeId;
    private String name;
    private String idName;

    public ExampleDTO(int employeeId, String name, String idName) {
        this.employeeId = employeeId;
        this.name = name;
        this.idName = idName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }
}
