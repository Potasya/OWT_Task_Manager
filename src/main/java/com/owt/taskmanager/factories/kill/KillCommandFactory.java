package main.java.com.owt.taskmanager.factories.kill;

import main.java.com.owt.taskmanager.commands.kill.KillCommand;
import main.java.com.owt.taskmanager.Process;
import main.java.com.owt.taskmanager.strategies.kill.KillStrategy;

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
