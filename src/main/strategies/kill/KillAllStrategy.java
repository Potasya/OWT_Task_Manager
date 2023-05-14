package main.strategies.kill;

import main.Process;

public class KillAllStrategy implements KillStrategy {
    @Override
    public boolean shouldKill(Process process) {
        return true;
    }
}
