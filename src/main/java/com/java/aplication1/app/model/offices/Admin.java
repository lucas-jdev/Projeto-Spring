package com.java.aplication1.app.model.offices;

import com.java.aplication1.app.model.Office;

public class Admin extends Employee{

    public Admin(String name) {
        super(name,Office.ADMIN,null);
    }

    @Override
    public String toString(){
        return "Admin(id="+super.getId()+", name="+super.getName()+", office="+super.getOffice()+", salary="+super.getSalary()+")";
    }
    
}