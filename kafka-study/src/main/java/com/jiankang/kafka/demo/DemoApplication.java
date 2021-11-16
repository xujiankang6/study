package com.jiankang.kafka.demo;

import com.jiankang.kafka.demo.design.AdvertisingDataReported;
import com.jiankang.kafka.demo.design.StrategyFactory;
import com.jiankang.kafka.demo.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication

public class DemoApplication implements ApplicationRunner {


    @Resource
    StrategyFactory strategyFactory;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("quickstart-events", msg);
    }



    @KafkaListener(topics = "quickstart-events", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }




    @Override
    public void run(ApplicationArguments args) throws Exception {

        sendMessage("Hi Welcome to Spring For Apache Kafka1");

        AdvertisingDataReported top = strategyFactory.getInstance("top");


        String aa = top.advertisingDataReported("aa");
    }
}
