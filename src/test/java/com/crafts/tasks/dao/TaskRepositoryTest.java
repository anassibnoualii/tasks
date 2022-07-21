package com.crafts.tasks.dao;

import com.crafts.tasks.dto.TaskStatus;
import com.crafts.tasks.entity.Task.Builder;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TaskRepositoryTest {

  @Autowired
  private TaskRepository taskRepository;

  @Test
  public void should_calculate_completed_tasks() {
    var task1 = Builder.create().withName("Task 1").withStatus(TaskStatus.TODO).build();
    var task2 = Builder.create().withName("Task 2").withStatus(TaskStatus.DONE).build();
    var task3 = Builder.create().withName("Task 3").withStatus(TaskStatus.IN_PROGRESS).build();
    var task4 = Builder.create().withName("Task 4").withStatus(TaskStatus.DONE).build();

    taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4));

    var result = taskRepository.countTaskByStatusEquals(TaskStatus.DONE);

    Assertions.assertThat(result).isEqualTo(2L);
  }
}
