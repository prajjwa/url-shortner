package com.tdd.learning_task_manager.controller;


import com.tdd.learning_task_manager.models.Task;
import com.tdd.learning_task_manager.service.TaskService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService=taskService;
    }


    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks()
    {

        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);

    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer taskId)
    {
        return new ResponseEntity<>(taskService.getTaskById(taskId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task)
    {
       return new ResponseEntity<>(taskService.createTask(task),HttpStatus.OK);
    }


}
