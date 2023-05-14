package test.strategies.kill;

import main.Process;
import main.Priority;
import main.strategies.kill.KillByPidStrategy;
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
