package com.example.customannotationproject.service;

import com.example.customannotationproject.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee getEmployeeById(){
        return new Employee(1,"munnaf","koi","koil");
    }

    public void save(Employee user) {
        System.out.println(user);
    }
}
