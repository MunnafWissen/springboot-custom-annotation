package com.example.entitygraph.kafkaproducer.controller;

import com.example.entitygraph.kafkaproducer.model.Employee;
import com.example.entitygraph.kafkaproducer.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    private final EmpService service;

    public EmpController(EmpService service){
        this.service = service;
    }

    @GetMapping("/")
    public String getMessage(){
        return "This is from producer application";
    }

    @PostMapping("/emp")
    public Employee saveEmployee(@RequestBody Employee emp){

        return service.saveEmployeeToConsumer(emp);

    }
}
