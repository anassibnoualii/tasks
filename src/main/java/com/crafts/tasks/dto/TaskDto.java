package com.crafts.tasks.dto;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

  private Long id;
  private String name;
  private TaskStatus status;

  public static final class Builder {

    private Long id;
    private String name;
    private TaskStatus status;

    private Builder() {
    }

    public static Builder create() {
      return new Builder();
    }

    public Builder withId(Long id) {
      this.id = id;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withStatus(TaskStatus status) {
      this.status = status;
      return this;
    }

    public TaskDto build() {
      TaskDto taskDto = new TaskDto();
      taskDto.setId(id);
      taskDto.setName(name);
      taskDto.setStatus(status);
      return taskDto;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDto taskDto = (TaskDto) o;
    return Objects.equals(id, taskDto.id) && Objects.equals(name, taskDto.name)
        && status == taskDto.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status);
  }
}
