package com.crafts.tasks.service;

import com.crafts.tasks.dao.TaskRepository;
import com.crafts.tasks.dto.TaskDto;
import com.crafts.tasks.mapper.TaskMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

  private final TaskMapper taskMapper;
  private final TaskRepository taskRepository;

  public TaskDto addTask(TaskDto taskDto) {
    return taskMapper.taskToTaskDto(taskRepository.save(taskMapper.taskDtoToTask(taskDto)));
  }


  public TaskDto getTask(Long id) {
    return taskRepository.findById(id).map(taskMapper::taskToTaskDto).orElse(null);
  }

  public List<TaskDto> getTasks() {
    return taskRepository.findAll()
        .stream()
        .map(taskMapper::taskToTaskDto)
        .collect(Collectors.toList());
  }
}
