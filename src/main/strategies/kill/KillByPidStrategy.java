package main.strategies.kill;

import main.Process;

public class KillByPidStrategy implements KillStrategy {
    private final String pid;

    public KillByPidStrategy(String pid) {
        this.pid = pid;
    }

    @Override
    public boolean shouldKill(Process process) {
        return process.getPid().equals(pid);
    }
}