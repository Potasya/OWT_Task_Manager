package main.java.com.owt.taskmanager.strategies.kill;
import main.java.com.owt.taskmanager.Process;

public interface KillStrategy {
    boolean shouldKill(Process process);
}