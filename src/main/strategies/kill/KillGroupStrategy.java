package main.strategies.kill;

import main.Process;
import main.Priority;

public class KillGroupStrategy implements KillStrategy {
    private final Priority priority;

    public KillGroupStrategy(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean shouldKill(Process process) {
        return process.getPriority() == priority;
    }
}
