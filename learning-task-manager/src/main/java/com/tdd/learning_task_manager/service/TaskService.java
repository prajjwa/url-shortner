package com.tdd.learning_task_manager.service;

import com.tdd.learning_task_manager.exceptions.TaskNotFoundException;
import com.tdd.learning_task_manager.models.Task;
import com.tdd.learning_task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task updateTask(int id, String status)
    {
       Task foundTask=getTaskById(id);

       foundTask.setStatus(status);

       return taskRepository.save(foundTask);

    }




    public Task getTaskById(Integer id)
    {
        return taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found exception "+id));
    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    public void deleteTask(int id) {

        Task taskToDelete=getTaskById(id);

        taskRepository.delete(taskToDelete);


    }
}
