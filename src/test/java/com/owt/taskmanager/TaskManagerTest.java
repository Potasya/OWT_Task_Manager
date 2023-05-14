package test.java.com.owt.taskmanager;

import main.java.com.owt.taskmanager.Priority;
import main.java.com.owt.taskmanager.strategies.add.*;
import main.java.com.owt.taskmanager.strategies.kill.*;
import main.java.com.owt.taskmanager.TaskManager;
import main.java.com.owt.taskmanager.Process;

import main.java.com.owt.taskmanager.strategies.list.ListByPriorityStrategy;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    public void testAddProcess() {
        TaskManager taskManager = new TaskManager(3, new DefaultAddProcessStrategy());
        assertTrue(taskManager.add(new Process("1", Priority.LOW)));
        assertTrue(taskManager.add(new Process("2", Priority.MEDIUM)));
        assertTrue(taskManager.add(new Process("3", Priority.HIGH)));
        assertFalse(taskManager.add(new Process("4", Priority.LOW)));
    }

    @Test
    public void testListProcesses() {
        TaskManager taskManager = new TaskManager(3, new DefaultAddProcessStrategy());
        taskManager.add(new Process("1", Priority.LOW));
        taskManager.add(new Process("2", Priority.MEDIUM));
        taskManager.add(new Process("3", Priority.HIGH));
        List<Process> processes = taskManager.list(new ListByPriorityStrategy());
        assertEquals(3, processes.size());
    }

    @Test
    public void testKillProcess() {
        TaskManager taskManager = new TaskManager(3, new DefaultAddProcessStrategy());
        taskManager.add(new Process("1", Priority.LOW));
        taskManager.add(new Process("2", Priority.MEDIUM));
        taskManager.add(new Process("3", Priority.HIGH));
        taskManager.kill(new KillByPidStrategy("2"));
        List<Process> processes = taskManager.list(new ListByPriorityStrategy());
        assertEquals(2, processes.size());
    }

    @Test
    public void testKillNonexistentProcess() {
        TaskManager taskManager = new TaskManager(3, new DefaultAddProcessStrategy());
        taskManager.add(new Process("1", Priority.LOW));
        taskManager.add(new Process("2", Priority.MEDIUM));
        taskManager.add(new Process("3", Priority.HIGH));

        // Nonexistent PID
        taskManager.kill(new KillByPidStrategy("4"));
        List<Process> processes = taskManager.list(new ListByPriorityStrategy());

        // No process should be killed
        assertEquals(3, processes.size());
    }

    @Test
    public void testAddProcessToFifoWithCapacity() {
        TaskManager taskManager = new TaskManager(3, new FIFOAddProcessStrategy());
        assertTrue(taskManager.add(new Process("1", Priority.LOW)));
        assertTrue(taskManager.add(new Process("2", Priority.MEDIUM)));
        assertTrue(taskManager.add(new Process("3", Priority.HIGH)));

        // This should succeed
        assertTrue(taskManager.add(new Process("4", Priority.LOW)));
        List<Process> processes = taskManager.list(new ListByPriorityStrategy());

        // Process "1" should have been replaced
        assertEquals(3, processes.size());
        assertFalse(processes.stream().anyMatch(p -> p.getPid().equals("1")));
    }

    @Test
    public void testKillAllProcesses() {
        TaskManager taskManager = new TaskManager(3, new DefaultAddProcessStrategy());
        taskManager.add(new Process("1", Priority.LOW));
        taskManager.add(new Process("2", Priority.MEDIUM));
        taskManager.add(new Process("3", Priority.HIGH));
        taskManager.kill(new KillAllStrategy());
        List<Process> processes = taskManager.list(new ListByPriorityStrategy());

        // All processes should be killed
        assertTrue(processes.isEmpty());
    }

}
