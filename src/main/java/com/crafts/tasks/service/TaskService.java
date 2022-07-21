package com.crafts.tasks.service;

import com.crafts.tasks.dto.TaskDto;
import java.util.List;

public interface TaskService {

  TaskDto addTask(TaskDto taskDto);

  TaskDto getTask(Long id);

  List<TaskDto> getTasks();
}
