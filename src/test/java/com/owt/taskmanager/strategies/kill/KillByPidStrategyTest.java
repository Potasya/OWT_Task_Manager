package test.java.com.owt.taskmanager.strategies.kill;

import main.java.com.owt.taskmanager.Process;
import main.java.com.owt.taskmanager.Priority;
import main.java.com.owt.taskmanager.strategies.kill.KillByPidStrategy;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class KillByPidStrategyTest {

    @Test
    public void testShouldKill() {
        KillByPidStrategy strategy = new KillByPidStrategy("1");
        assertTrue(strategy.shouldKill(new Process("1", Priority.LOW)));
        assertFalse(strategy.shouldKill(new Process("2", Priority.MEDIUM)));
    }
}
