package com.tdd.learning_task_manager.repository;

import com.tdd.learning_task_manager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {


}
