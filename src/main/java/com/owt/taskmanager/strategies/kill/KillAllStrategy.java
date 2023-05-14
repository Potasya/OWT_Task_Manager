package main.java.com.owt.taskmanager.strategies.kill;

import main.java.com.owt.taskmanager.Process;

public class KillAllStrategy implements KillStrategy {
    @Override
    public boolean shouldKill(Process process) {
        return true;
    }
}
