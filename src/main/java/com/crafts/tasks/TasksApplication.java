package com.crafts.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Slf4j
@Configuration
public class TasksApplication {

  public static void main(String[] args) {
    SpringApplication.run(TasksApplication.class, args);
  }

}
