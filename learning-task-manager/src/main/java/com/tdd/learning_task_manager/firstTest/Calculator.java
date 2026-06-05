package com.tdd.learning_task_manager.firstTest;

import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

public class Calculator {

    public double divideTwoNumbers(double one,double two)
    {
        if(two==0)throw new ArithmeticException("Cannot divide by zero.");

        return one/two;
    }

}
