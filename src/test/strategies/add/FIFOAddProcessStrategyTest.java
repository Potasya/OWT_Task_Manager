package test.strategies.add;

import main.Priority;
import main.Process;
import main.strategies.add.FIFOAddProcessStrategy;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FIFOAddProcessStrategyTest {

    @Test
    public void testAdd() {
        FIFOAddProcessStrategy strategy = new FIFOAddProcessStrategy();
        List<Process> processes = new ArrayList<>();
        assertTrue(strategy.add(new Process("1", Priority.LOW), processes, 3));
        assertTrue(strategy.add(new Process("2", Priority.MEDIUM), processes, 3));
        assertTrue(strategy.add(new Process("3", Priority.HIGH), processes, 3));
        assertTrue(strategy.add(new Process("4", Priority.LOW), processes, 3));
        assertEquals(3, processes.size());
        assertFalse(processes.contains(new Process("1", Priority.LOW)));
    }
}
