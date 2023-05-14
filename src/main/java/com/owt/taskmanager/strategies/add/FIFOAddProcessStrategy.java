package main.java.com.owt.taskmanager.strategies.add;

import main.java.com.owt.taskmanager.Process;

import java.util.List;

public class FIFOAddProcessStrategy implements AddProcessStrategy {
    @Override
    public boolean add(Process process, List<Process> processes, int capacity) {
        if (processes.size() >= capacity) {
            processes.remove(0);
        }
        return processes.add(process);
    }
}