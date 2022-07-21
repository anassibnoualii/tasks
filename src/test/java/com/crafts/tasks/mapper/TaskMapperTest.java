package com.crafts.tasks.mapper;

import com.crafts.tasks.dto.TaskDto;
import com.crafts.tasks.dto.TaskStatus;
import com.crafts.tasks.entity.Task;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TaskMapperTest {

  private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

  @Test
  public void should_map_task_to_task_dto() {
    //Given
    var taskInput = Task.Builder.create().withId(1L)
        .withName("Task 1")
        .withStatus(TaskStatus.TODO).build();

    var taskDtoOutput = TaskDto.Builder.create().withId(1L)
        .withName("Task 1")
        .withStatus(TaskStatus.TODO).build();

    //when
    var result = taskMapper.taskToTaskDto(taskInput);

    //Then
    Assertions.assertThat(result).isEqualTo(taskDtoOutput);
  }

  @Test
  public void should_map_task_dto_to_task() {
    //Given
    var taskInput = TaskDto.Builder.create().withId(1L)
        .withName("Task 1")
        .withStatus(TaskStatus.TODO).build();

    var taskDtoOutput = Task.Builder.create().withId(1L)
        .withName("Task 1")
        .withStatus(TaskStatus.TODO).build();

    //when
    var result = taskMapper.taskDtoToTask(taskInput);

    //Then
    Assertions.assertThat(result).isEqualTo(taskDtoOutput);
  }
}
