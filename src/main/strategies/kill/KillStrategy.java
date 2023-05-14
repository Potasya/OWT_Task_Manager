package main.strategies.kill;
import main.Process;

public interface KillStrategy {
    boolean shouldKill(Process process);
}