package com.java.aplication1.app.controller;

import java.util.List;
import java.util.Optional;

import com.java.aplication1.app.data.EmployeeRepository;
import com.java.aplication1.app.model.dtos.EmployeeDTO;
import com.java.aplication1.app.model.offices.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hr")
public class HumanResourcesController {
    
    /*CRUD cujo acesso é somente para o RH */

    @Autowired /*injeção de dependência*/
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "toSave")
    @ResponseBody
    public ResponseEntity<Employee> toSave(@RequestBody EmployeeDTO employeeDTO){
        var employee = employeeRepository.save(new Employee(employeeDTO));  
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping(value = "findEmployeeById")
    @ResponseBody
    public ResponseEntity<Employee> findEmployeeById(@RequestParam(name = "idEmployee") Long idEmployee){
        Optional<Employee> optional = employeeRepository.findById(idEmployee);
        var employee = optional.orElse(new Employee());
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping(value = "findEmployeeByName")
    @ResponseBody
    public ResponseEntity<List<Employee>> findEmployeeByName(@RequestParam(name = "name") String name){
        var employees = employeeRepository.findByName(name.trim().toUpperCase());
        return new ResponseEntity<>(employees,HttpStatus.OK);   
    }

    @PutMapping(value = "toUpdate")
    @ResponseBody
    public ResponseEntity<Employee> toUpdate(@RequestBody Employee employee){
        var employeeTemp  = employeeRepository.saveAndFlush(employee);
        return new ResponseEntity<>(employeeTemp, HttpStatus.OK);
    }

    @DeleteMapping(value = "toDelete")
    @ResponseBody
    public ResponseEntity<String> toDelete(@RequestParam(name = "idEmployee") Long idEmployee){
        employeeRepository.deleteById(idEmployee);
        return new ResponseEntity<>("Funcionário deletado com sucesso", HttpStatus.OK);
    }

    @GetMapping(value = "toList")
    @ResponseBody
    public ResponseEntity<List<Employee>> toList(){
        var employees = employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
