package test.java.com.owt.taskmanager.strategies.kill;

import main.java.com.owt.taskmanager.Process;
import main.java.com.owt.taskmanager.Priority;
import main.java.com.owt.taskmanager.strategies.kill.KillGroupStrategy;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class KillGroupStrategyTest {

    @Test
    public void testShouldKill() {
        KillGroupStrategy strategy = new KillGroupStrategy(Priority.LOW);
        assertTrue(strategy.shouldKill(new Process("1", Priority.LOW)));
        assertFalse(strategy.shouldKill(new Process("2", Priority.MEDIUM)));
        assertFalse(strategy.shouldKill(new Process("3", Priority.HIGH)));
    }
}
