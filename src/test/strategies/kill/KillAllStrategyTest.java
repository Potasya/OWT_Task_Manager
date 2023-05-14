package test.strategies.kill;

import main.Process;
import main.Priority;
import main.strategies.kill.KillAllStrategy;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class KillAllStrategyTest {

    @Test
    public void testShouldKill() {
        KillAllStrategy strategy = new KillAllStrategy();
        assertTrue(strategy.shouldKill(new Process("1", Priority.LOW)));
        assertTrue(strategy.shouldKill(new Process("2", Priority.MEDIUM)));
        assertTrue(strategy.shouldKill(new Process("3", Priority.HIGH)));
    }
}
