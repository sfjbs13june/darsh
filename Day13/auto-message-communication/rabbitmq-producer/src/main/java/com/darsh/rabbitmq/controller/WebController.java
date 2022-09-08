package com.darsh.rabbitmq.controller;

import com.darsh.rabbitmq.model.Employee;
import com.darsh.rabbitmq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class WebController {
  @Autowired
  RabbitMQSender rabbitMQSender;

  @GetMapping(value = "/producer")
  public String producer(@RequestParam("to") String to, @RequestParam("from") String from, @RequestParam("content") String content) {
    String correlationId = UUID.randomUUID().toString();
    Employee emp=new Employee();
    emp.setTo(to);
    emp.setFrom(from);
    emp.setContent(content);
    emp.setCorrelationId(correlationId);
    rabbitMQSender.send(emp);

    return "Message sent to the RabbitMQ  Successfully";
  }
}
