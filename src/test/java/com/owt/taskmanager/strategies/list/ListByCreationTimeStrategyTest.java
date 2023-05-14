package test.java.com.owt.taskmanager.strategies.list;

import main.java.com.owt.taskmanager.Process;
import main.java.com.owt.taskmanager.Priority;
import main.java.com.owt.taskmanager.strategies.list.ListByCreationTimeStrategy;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListByCreationTimeStrategyTest {

    @Test
    public void testListByCreationTimeStrategy() {
        ListByCreationTimeStrategy strategy = new ListByCreationTimeStrategy();
        Process p1 = new Process("1", Priority.LOW);
        Process p2 = new Process("2", Priority.MEDIUM);
        Process p3 = new Process("3", Priority.HIGH);
        List<Process> processes = Arrays.asList(p1, p2, p3);
        processes = strategy.list(processes);
        assertEquals(p1, processes.get(0));
        assertEquals(p2, processes.get(1));
        assertEquals(p3, processes.get(2));
    }
}