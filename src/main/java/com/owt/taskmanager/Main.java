package main.java.com.owt.taskmanager;

import main.java.com.owt.taskmanager.strategies.add.*;
import main.java.com.owt.taskmanager.strategies.kill.*;
import main.java.com.owt.taskmanager.strategies.list.ListByCreationTimeStrategy;
import main.java.com.owt.taskmanager.strategies.list.ListByPriorityStrategy;

public class Main {
    public static void main(String[] args) {
        // Create a task manager with a capacity of 3 using the default add process strategy
        TaskManager taskManager = new TaskManager(3, new DefaultAddProcessStrategy());

        // Add processes
        taskManager.add(new Process("1", Priority.HIGH));
        taskManager.add(new Process("2", Priority.MEDIUM));
        taskManager.add(new Process("3", Priority.LOW));

        // Add another process - this should fail
        boolean added = taskManager.add(new Process("4", Priority.LOW));
        // Should print: Added process: false
        System.out.println("Added process: " + added);

        // List the running processes
        // Should print: [Process[3, LOW], Process[2, MEDIUM], Process[1, HIGH]]
        System.out.println(taskManager.list(new ListByPriorityStrategy()));

        // Kill the process with PID "2"
        taskManager.kill(new KillByPidStrategy("2"));

        // Should print: [Process[3, LOW], Process[1, HIGH]]
        System.out.println(taskManager.list(new ListByPriorityStrategy()));

        // Switch to the FIFO add process strategy
        taskManager = new TaskManager(3, new FIFOAddProcessStrategy());

        // Add some processes
        taskManager.add(new Process("1", Priority.LOW));
        taskManager.add(new Process("2", Priority.MEDIUM));
        taskManager.add(new Process("3", Priority.HIGH));

        // Try to add another process - this should succeed and the oldest process ("1") should be removed
        added = taskManager.add(new Process("4", Priority.LOW));

        // Should print: Added process: true
        System.out.println("Added process: " + added);
        // Should print: [Process[2, MEDIUM], Process[3, HIGH], Process[4, LOW]]
        System.out.println(taskManager.list(new ListByCreationTimeStrategy()));
        // Should print: [Process[4, LOW], Process[2, MEDIUM], Process[3, HIGH]]
        System.out.println(taskManager.list(new ListByPriorityStrategy()));

        // Kill all processes
        taskManager.kill(new KillAllStrategy());
        // Should print: []
        System.out.println(taskManager.list(new ListByCreationTimeStrategy()));
    }
}