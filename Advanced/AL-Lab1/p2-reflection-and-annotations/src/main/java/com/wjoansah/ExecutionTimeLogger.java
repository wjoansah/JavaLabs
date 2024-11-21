package com.wjoansah;

import java.lang.reflect.Method;

public class ExecutionTimeLogger {
    public static void logExecutionTime(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();

            method.invoke(obj, args);

            long executionTime = System.nanoTime() - startTime;

            System.out.println("Execution time: " + executionTime + " ns");
        } else {
            System.out.println("Method " + methodName + " is not annotated with @LogExecutionTime");
        }
    }

    public static void logExecutionTime(Class<?> clazz, String methodName) throws Exception {
        // Get the static method from the class
        Method method = clazz.getMethod(methodName);

        // Check if the method is annotated with @LogExecutionTime
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.currentTimeMillis();

            // Invoke the static method (use null for static methods)
            method.invoke(null);

            long executionTime = System.currentTimeMillis() - startTime;
            System.out.println(methodName + " executed in " + executionTime + "ms");
        } else {
            System.out.println("Method " + methodName + " is not annotated with @LogExecutionTime");
        }
    }
}
