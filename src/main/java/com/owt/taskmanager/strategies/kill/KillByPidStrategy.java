package main.java.com.owt.taskmanager.strategies.kill;

import main.java.com.owt.taskmanager.Process;

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