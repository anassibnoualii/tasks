package com.crafts.tasks.mapper;

import com.crafts.tasks.dto.TaskDto;
import com.crafts.tasks.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

  TaskDto taskToTaskDto(Task task);

  Task taskDtoToTask(TaskDto taskDto);
}
