package com.example.entitygraph.kafkaconsumer.controller;

import com.example.entitygraph.kafkaconsumer.model.Employee;
import com.example.entitygraph.kafkaconsumer.service.EmpConsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpConsController {

    private final EmpConsService service;

    public EmpConsController(EmpConsService service){
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }
}
