package main.factories.kill;

import main.commands.kill.KillCommand;
import main.Process;
import main.strategies.kill.KillStrategy;

import java.util.List;

public class KillCommandFactory {
    public KillCommand createKillCommand(KillStrategy strategy, List<Process> processes) {
        return () -> processes.removeIf(process -> {
            if (!strategy.shouldKill(process)) {
                return false;
            }
            process.kill();
            return true;
        });
    }
}
