package com.example.entitygraph.demo.service;

import com.example.entitygraph.demo.model.User;
import com.example.entitygraph.demo.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo repo;

    public UserService(UserRepo repo){
        this.repo = repo;
    }

    public List<User> getAllUsers(){
        List<User>  list = repo.findAll();
        if(list.isEmpty()){
            System.out.println("list is empty");

        }
        System.out.println(list);
        return list;
    }
}
