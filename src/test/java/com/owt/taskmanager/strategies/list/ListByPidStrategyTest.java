package test.java.com.owt.taskmanager.strategies.list;

import main.java.com.owt.taskmanager.Process;
import main.java.com.owt.taskmanager.Priority;
import main.java.com.owt.taskmanager.strategies.list.ListByPidStrategy;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListByPidStrategyTest {

    @Test
    public void testListByPidStrategy() {
        ListByPidStrategy strategy = new ListByPidStrategy();
        Process p1 = new Process("3", Priority.LOW);
        Process p2 = new Process("1", Priority.MEDIUM);
        Process p3 = new Process("2", Priority.HIGH);
        List<Process> processes = Arrays.asList(p1, p2, p3);
        processes = strategy.list(processes);
        assertEquals("1", processes.get(0).getPid());
        assertEquals("2", processes.get(1).getPid());
        assertEquals("3", processes.get(2).getPid());
    }
}
