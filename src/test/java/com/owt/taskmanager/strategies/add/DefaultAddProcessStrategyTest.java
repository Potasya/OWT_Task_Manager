package test.java.com.owt.taskmanager.strategies.add;

import main.java.com.owt.taskmanager.Priority;
import main.java.com.owt.taskmanager.Process;
import main.java.com.owt.taskmanager.strategies.add.DefaultAddProcessStrategy;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultAddProcessStrategyTest {

    @Test
    public void testAdd() {
        DefaultAddProcessStrategy strategy = new DefaultAddProcessStrategy();
        List<Process> processes = new ArrayList<>();
        assertTrue(strategy.add(new Process("1", Priority.LOW), processes, 3));
        assertTrue(strategy.add(new Process("2", Priority.MEDIUM), processes, 3));
        assertTrue(strategy.add(new Process("3", Priority.HIGH), processes, 3));
        assertFalse(strategy.add(new Process("4", Priority.LOW), processes, 3));
    }

}
