package com.tdd.learning_task_manager.service;


import com.tdd.learning_task_manager.exceptions.TaskNotFoundException;
import com.tdd.learning_task_manager.models.Task;
import com.tdd.learning_task_manager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testGetTaskById_TaskNotFound()
    {

        // arrange
        when(taskRepository.findById(1)).thenReturn(Optional.empty());

        //act and assert
        assertThrows(TaskNotFoundException.class,()->taskService.getTaskById(1));

        verify(taskRepository,times(1)).findById(1);

    }

    @Test
    void testGetTaskById()
    {
        Task task=new Task(2,"Dog","Pending");

        when(taskRepository.findById(2)).thenReturn(Optional.of(task));

        Task retrievedTask=taskService.getTaskById(2);

        assertNotNull(retrievedTask);
        assertEquals(2,retrievedTask.getId());
        assertEquals("Dog",retrievedTask.getTitle());
        assertEquals("Pending",retrievedTask.getStatus());



    }

    @Test
    public void testCreateTask()
    {
        Task task=new Task("Created","Created");

        when(taskRepository.save(task)).thenReturn(task);

        Task createdTask=taskService.createTask(task);

        assertNotNull(createdTask);
        assertEquals("Created",createdTask.getTitle());
        assertEquals("Created",createdTask.getStatus());

        verify(taskRepository,times(1)).save(task);

    }

    @Test
    public void testDeleteTask()
    {

        Task existingTask=new Task(1,"Test task to delete","Deleted");

        when(taskRepository.findById(1)).thenReturn(Optional.of(existingTask));


        taskService.deleteTask(1);

        verify(taskRepository).delete(existingTask);



    }


    @Test
    public void getAllTasks()
    {


        List<Task> tasks= Arrays.asList(
          new Task("Task 1","To do"),
          new Task("Task 2","In progress")
        );

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> retrivedTaskList=taskService.getAllTasks();

        assertEquals(2,retrivedTaskList.size());
        verify(taskRepository,times(1)).findAll();

    }

    @Test
    public void testUpdateTaskStatus()
    {
        Task task=new Task(190,"Existing","Pending");

        when(taskRepository.findById(190)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task updatedTask=taskService.updateTask(190,"OPP");

        assertNotNull(updatedTask);
        assertEquals("OPP",updatedTask.getStatus());
        verify(taskRepository,times(1)).findById(190);
        verify(taskRepository,times(1)).save(task);

    }


    @Test
    void testDeleteTask_TaskNotFound()
    {
        when(taskRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,()->taskService.deleteTask(1));

        verify(taskRepository,times(1)).findById(1);
    }

    @Test
    void updateTask()
    {
        Task existingTask=new Task(1,"Old","CREATED");
        Task newTask=new Task("New","New");
        when(taskRepository.findById(1)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(any(Task.class))).thenAnswer(invocationOnMock ->
            invocationOnMock.getArgument(0)
            );

        taskService.updateTask(1, String.valueOf(newTask));

        verify(taskRepository,times(1)).findById(1);
        verify(taskRepository,times(1)).save(newTask);


    }




}
