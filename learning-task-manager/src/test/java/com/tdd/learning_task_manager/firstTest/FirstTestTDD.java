package com.tdd.learning_task_manager.firstTest;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FirstTestTDD {

    @Test
    public void testDivideOfTwoNumbers()
    {
        Calculator calculator=new Calculator();

        double expectedResult=2;
        double gotResult=calculator.divideTwoNumbers(4,2);

        assertEquals(expectedResult,gotResult);

    }

    @Test
    public void divideByZero()
    {
        Calculator calculator=new Calculator();

        assertThrows(ArithmeticException.class,()->calculator.divideTwoNumbers(3,0));
    }

}
