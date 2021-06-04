package com.java.aplication1.app.data;

import java.util.List;

import com.java.aplication1.app.model.Office;
import com.java.aplication1.app.model.offices.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    @Query(value = "select em from Employee em where upper(trim(em.name)) like %?1%")
    List<Employee> findByName(String name);

    @Query(value = "select * from Employee * where *.office like %?1%")
    List<Employee> findByOffice(Office office);

    @Query(value = "select * from Employee * where *.office like %")
    List<Employee> findBySalary(Float salary);
}
