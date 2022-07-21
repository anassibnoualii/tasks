package com.crafts.tasks.service;

import static org.mockito.Mockito.when;

import com.crafts.tasks.dao.TaskRepository;
import com.crafts.tasks.dto.TaskDto;
import com.crafts.tasks.dto.TaskStatus;
import com.crafts.tasks.entity.Task.Builder;
import com.crafts.tasks.mapper.TaskMapper;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

  @Mock
  TaskRepository taskRepository;
  @Mock
  TaskMapper taskMapper;
  @InjectMocks
  TaskServiceImpl taskService;

  @Test
  public void should_get_task_by_id() {

    var taskEntity = Builder.create()
        .withId(1L)
        .withName("Task 1")
        .withStatus(TaskStatus.TODO)
        .build();
    when(taskRepository.findById(1L)).thenReturn(Optional.of(taskEntity));

    var taskDtoResult = TaskDto.Builder.create()
        .withId(1L)
        .withName("Task 1")
        .withStatus(TaskStatus.TODO)
        .build();

    when(taskMapper.taskToTaskDto(taskEntity)).thenReturn(taskDtoResult);

    var result = taskService.getTask(1L);

    Assertions.assertThat(result).isEqualTo(taskDtoResult);
  }
}
