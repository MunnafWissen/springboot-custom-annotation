package com.example.entitygraph.kafkaconsumer.service;

import com.example.entitygraph.kafkaconsumer.controller.EmpConsController;
import com.example.entitygraph.kafkaconsumer.model.Employee;
import com.example.entitygraph.kafkaconsumer.repo.EmpRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpConsService {

    private final EmpRepo empRepo;
    private final Logger log = LoggerFactory.getLogger(EmpConsController.class);

    public EmpConsService(EmpRepo empRepo){
        this.empRepo = empRepo;
    }

    @RetryableTopic(
            attempts = "3",
            backOff = @BackOff(delay = 2000),
            dltTopicSuffix = "-dlt",
            exclude = {Exception.class}
    )
    @KafkaListener(topics = "save-topic", groupId = "empconsumer-group")
    public Employee saveEmployee(@Payload Employee emp){

        log.info("in consumer service, emp record is saved ");
        return empRepo.save(emp);
    }

    @KafkaListener(topics = "save-topic-dlt", groupId = "empconsumer-dlt-group")
    public void handleDLT(Employee emp){
        log.warn("in handling DLT, emp record in consumer group");
        log.info("emp record is sent to DLT topic: {}", emp.getName());

    }


    public List<Employee> getAllEmployees() {
        log.info("getting all employee records from consumer service");
        return empRepo.findAll();
    }
}
