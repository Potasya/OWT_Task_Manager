package main;

import main.commands.kill.KillCommand;
import main.factories.kill.KillCommandFactory;
import main.strategies.add.AddProcessStrategy;
import main.strategies.kill.KillStrategy;
import main.strategies.list.ListStrategy;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final int capacity;
    private final List<Process> processes;
    private final AddProcessStrategy addProcessStrategy;
    private final KillCommandFactory killCommandFactory;

    public TaskManager(int capacity, AddProcessStrategy addProcessStrategy) {
        this.capacity = capacity;
        this.processes = new ArrayList<>(capacity);
        this.addProcessStrategy = addProcessStrategy;
        this.killCommandFactory = new KillCommandFactory();
    }

    public boolean add(Process process) {
        return addProcessStrategy.add(process, processes, capacity);
    }

    public List<Process> list(ListStrategy strategy) {
        return strategy.list(processes);
    }

    public void kill(KillStrategy strategy) {
        KillCommand command = killCommandFactory.createKillCommand(strategy, processes);
        command.execute();
    }
}
