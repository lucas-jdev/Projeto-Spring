package com.java.aplication1.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Office{

    INTERN("Intern") {
        @Override
        public Float salary() {
            return new ConstantsSalarys().getInternSalary();
        }
    } ,ADMIN("Admin") {
        @Override
        public Float salary() {
            return new ConstantsSalarys().getAdminSalary();
        }
    } ,MANAGER("Manager") {
        @Override
        public Float salary() {
            return new ConstantsSalarys().getManagerSalary();
        }
    } , HUMAN_RESOURSES("Human resourses") {
        @Override
        public Float salary() {
            return new ConstantsSalarys().getHumanResoursesSalary();
        }
    };

    private String nameOffice;

    public abstract Float salary();

}