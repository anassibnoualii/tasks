package com.crafts.tasks.controller;

import com.crafts.tasks.dto.TaskDto;
import com.crafts.tasks.service.TaskService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @GetMapping
  ResponseEntity<List<TaskDto>> getTasks() {
    return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<TaskDto> addTask(@RequestBody TaskDto task) {
    return new ResponseEntity<>(taskService.addTask(task), HttpStatus.CREATED);
  }
}
