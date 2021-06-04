package com.java.aplication1.app.model.offices;

import com.java.aplication1.app.model.Office;

public class Intern extends Employee{

    public Intern(String name) {
        super(name, Office.INTERN, null);
    }

    @Override
    public String toString(){
        return "Intern(id="+super.getId()+", name="+super.getName()+", office="+super.getOffice()+", salary="+super.getSalary()+")";
    }
    
}
