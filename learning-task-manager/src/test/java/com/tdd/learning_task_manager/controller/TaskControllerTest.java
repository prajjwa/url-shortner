package com.tdd.learning_task_manager.controller;

import com.tdd.learning_task_manager.models.Task;
import com.tdd.learning_task_manager.service.TaskService;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @MockitoBean
    private TaskService taskService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllTasks() throws Exception {

        List<Task> tasks= Arrays.asList(
                new Task("Task 1","TODO"),
                new Task("Task 2","Created")
        );

        when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/tasks").contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].title").value("Task 1"))
                .andExpect(jsonPath("[1].title").value("Task 2"));



    }

    @Test
    public void createTask() throws Exception {
        Task task=new Task("Task Created","CREATED");

        when(taskService.createTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(
                post("/tasks")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(objectMapper.writeValueAsString(task))

        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Task Created"));

    }

    @Test
    public void createTaskWithInvalidInput() throws Exception {
        Task task=new Task("","Invalid");

        mockMvc.perform(
                post("/tasks")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(objectMapper.writeValueAsString(task))
        ).andExpect(status().isBadRequest());

    }

    @Test
    public void getTaskById() throws Exception {
        Task task=new Task(1,"New Task","Created");

        when(taskService.getTaskById(1)).thenReturn(task);

        mockMvc.perform(get("/tasks/1")
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                ;

    }

    @Test
    void updateTask() throws Exception{
        Task updatedTask=new Task(1,"Updated Task","In Progress");
        when(taskService.updateTask(eq(1), String.valueOf(ArgumentMatchers.any(Task.class))))
    }


}
