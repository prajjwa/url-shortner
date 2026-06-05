package com.tdd.learning_task_manager.repository;

import com.tdd.learning_task_manager.models.Task;
import com.tdd.learning_task_manager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// Use this line to configure the test to use the specified database
public class TaskRepositoryTest {

    @Autowired
   private TaskRepository taskRepository;

    @Test
    public void saveTask()
    {
        Task task=new Task("TASK1","CREATED");
        task.setStatus("CREATED");
        task.setTitle("TASK1");

        Task savedTask=taskRepository.save(task);

        assertNotNull(savedTask);
        assertEquals("TASK1",savedTask.getTitle());

    }

    @Test
    public void deleteTask()
    {
        Task task=new Task("Task to delete","DONE");
        task.setTitle("Task to delete");
        task.setStatus("Done");

        taskRepository.save(task);

        taskRepository.delete(task);

        Optional<Task> deletedTask=taskRepository.findById(task.getId());

        assertFalse(deletedTask.isPresent());

    }

    @Test
    public void findAllTasks(){

        Task task1=new Task("Task to add","CREATED");
        Task task2=new Task("Task to add 2","ADDED");
        List<Task> allTasks= Arrays.asList(task1,task2);
        taskRepository.saveAll(allTasks);

        assertEquals(2,allTasks.size());


    }

    @Test
    public void testUpdateTask()
    {
        Task task=new Task("Task to update","ADDED");
        taskRepository.save(task);

        task.setStatus("UPDATED");

        taskRepository.save(task);

        Optional<Task> optionalTask=taskRepository.findById(task.getId());

        assertFalse(optionalTask.isEmpty());

        assertEquals("UPDATED",optionalTask.get().getStatus());
    }


}
