package com.crafts.tasks.entity;

import com.crafts.tasks.dto.TaskStatus;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
  @SequenceGenerator(name = "task_id_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(id, task.id) && Objects.equals(name, task.name)
        && status == task.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status);
  }

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

    public Task build() {
      Task task = new Task();
      task.setId(id);
      task.setName(name);
      task.setStatus(status);
      return task;
    }
  }
}
