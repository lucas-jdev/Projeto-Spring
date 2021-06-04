package com.java.aplication1.app.model.offices;

import java.util.List;

import com.java.aplication1.app.model.Office;

public class HumanResourses extends Employee{

    public HumanResourses(String name) {
        super(name, Office.HUMAN_RESOURSES, null);
    }

    public void increaseEmployeeSalary(Employee employee, Float rateOfIncrease){
        var salaryWithIncrease = employee.getSalary() + (employee.getSalary() * rateOfIncrease);
        employee.setSalary(salaryWithIncrease);
    }

    public void decreaseEmployeeSalary(Employee employee, Float rateOfDecrease){
        var salaryWithDecrease = employee.getSalary() - (employee.getSalary() * rateOfDecrease);
        employee.setSalary(salaryWithDecrease);
    }

    public void fireEmployee(List<Employee> employees, Employee employee){
        employees.remove(employee);
    }

    @Override
    public String toString(){
        return "Human(id="+super.getId()+", name="+super.getName()+", office="+super.getOffice()+", salary="+super.getSalary()+")";
    }
}