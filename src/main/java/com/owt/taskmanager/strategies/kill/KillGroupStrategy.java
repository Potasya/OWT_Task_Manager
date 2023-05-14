package main.java.com.owt.taskmanager.strategies.kill;

import main.java.com.owt.taskmanager.Process;
import main.java.com.owt.taskmanager.Priority;

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
