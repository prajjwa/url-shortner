package com.tdd.learning_task_manager.exceptions;

import com.tdd.learning_task_manager.models.Task;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String message){
        super(message);
    }
}
