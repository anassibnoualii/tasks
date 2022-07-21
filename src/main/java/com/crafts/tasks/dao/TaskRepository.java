package com.crafts.tasks.dao;

import com.crafts.tasks.dto.TaskStatus;
import com.crafts.tasks.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  Long countTaskByStatusEquals(TaskStatus status);
}
