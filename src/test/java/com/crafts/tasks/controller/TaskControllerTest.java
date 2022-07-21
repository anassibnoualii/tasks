package com.crafts.tasks.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.crafts.tasks.dto.TaskDto;
import com.crafts.tasks.dto.TaskStatus;
import com.crafts.tasks.service.TaskService;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
@ActiveProfiles("test")
public class TaskControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TaskService taskService;


  @Test
  public void should_return_task_list() throws Exception {
    var task1 = TaskDto.Builder.create()
        .withId(1L)
        .withName("Task 1")
        .withStatus(TaskStatus.TODO)
        .build();
    var task2 = TaskDto.Builder.create()
        .withId(1L)
        .withName("Task 2")
        .withStatus(TaskStatus.IN_PROGRESS)
        .build();
    var task3 = TaskDto.Builder.create()
        .withId(1L)
        .withName("Task 3")
        .withStatus(TaskStatus.DONE)
        .build();

    Mockito.when(taskService.getTasks())
        .thenReturn(Arrays.asList(task1, task2, task3));

    mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
        .andExpect(status().is(200))
        .andExpect(content().json("[\n"
            + "  {\n"
            + "    \"id\": 1,\n"
            + "    \"name\": \"Task 1\",\n"
            + "    \"status\": \"TODO\"\n"
            + "  },\n"
            + "  {\n"
            + "    \"id\": 1,\n"
            + "    \"name\": \"Task 2\",\n"
            + "    \"status\": \"IN_PROGRESS\"\n"
            + "  },\n"
            + "  {\n"
            + "    \"id\": 1,\n"
            + "    \"name\": \"Task 3\",\n"
            + "    \"status\": \"DONE\"\n"
            + "  }\n"
            + "]"));
  }
}
