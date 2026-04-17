package com.example.customannotationproject.controller;

import com.example.customannotationproject.model.Employee;
import com.example.customannotationproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControler {


    private final EmployeeService service;

    public EmployeeControler(EmployeeService service) {
        this.service = service;
    }



    @PostMapping("/emp")
    public void createEmployee(@Valid @RequestBody Employee user){
        service.save(user);
    }

    public Employee getEmployeeById(){
        service.getEmployeeById();
        return new Employee();
    }
}
