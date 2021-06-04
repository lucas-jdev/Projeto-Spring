package com.java.aplication1.app.model.dtos;

import com.java.aplication1.app.model.Office;
import com.java.aplication1.app.model.offices.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    
    private String name;
    private Office office;

    public EmployeeDTO(){}
    public EmployeeDTO(String name, Office office){
        this.name = name;
        this.office = office;
    }

    public EmployeeDTO(Employee employee){
        this.name = employee.getName();
        this.office = employee.getOffice();
    }
}
