package main.java.com.owt.taskmanager;

import main.java.com.owt.taskmanager.commands.kill.KillCommand;
import main.java.com.owt.taskmanager.factories.kill.KillCommandFactory;
import main.java.com.owt.taskmanager.strategies.add.AddProcessStrategy;
import main.java.com.owt.taskmanager.strategies.kill.KillStrategy;
import main.java.com.owt.taskmanager.strategies.list.ListStrategy;

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
