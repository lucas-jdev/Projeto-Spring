package com.java.aplication1.app.model.offices;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.java.aplication1.app.model.Office;
import com.java.aplication1.app.model.dtos.EmployeeDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "seq_employee", sequenceName = "seq_employee", allocationSize = 1, initialValue = 1)
@Data
@NoArgsConstructor
public class Employee implements Serializable{


    @Getter(value = AccessLevel.PRIVATE)
    private static final Long serialVersionUID = 1L;
    
    /*
    * essa classe é para model principal, onde possuíra...
    * @param id,name,office e salary são atributos
    */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee")
    private Long id;
    private String name;
    private Office office;
    private Float salary;

    public Employee(String name, Office office, Float salary) {
        this.name = name;
        this.office = office;
        this.salary = salary;
    }

    public Employee(EmployeeDTO dto){
        name = dto.getName();
        office = dto.getOffice();
        setSalaryByOffice(office);
    }

    /* esse metódo serve para modificar o salário com base no
        cargo passado no parâmetro. */
    /* Se cargo passado não for igual ao do objeto, o salário 
       não muda */
    public void setSalaryByOffice(Office office) {
        if (this.office != null && this.office.equals(office)) {
            salary = office.salary();
        }
    }

    // esse metódo é necessário para poder fazer polimorfismo
    public void setSalary(Float salary){
        this.salary = salary;
    }


}