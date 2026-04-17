package com.example.entitygraph.kafkaproducer.service;

import com.example.entitygraph.kafkaproducer.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpService {


    private final Logger log = LoggerFactory.getLogger(EmpService.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EmpService(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public Employee saveEmployeeToConsumer(Employee emp) {
        kafkaTemplate.send("save-topic", emp);
        log.info("emp record is sent to consumer service from producer service: {}", emp.getName());
        return emp;
    }
}
