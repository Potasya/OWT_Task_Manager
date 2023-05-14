package test.strategies.list;

import main.Priority;
import main.strategies.list.ListByPriorityStrategy;
import org.junit.jupiter.api.*;
import main.Process;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListByPriorityStrategyTest {
    @Test
    public void testListByPriorityStrategy() {
        ListByPriorityStrategy strategy = new ListByPriorityStrategy();
        List<Process> processes = Arrays.asList(
                new Process("1", Priority.HIGH),
                new Process("2", Priority.MEDIUM),
                new Process("3", Priority.LOW)
        );
        processes = strategy.list(processes);
        assertEquals(Priority.LOW, processes.get(0).getPriority());
        assertEquals(Priority.MEDIUM, processes.get(1).getPriority());
        assertEquals(Priority.HIGH, processes.get(2).getPriority());
    }
}
