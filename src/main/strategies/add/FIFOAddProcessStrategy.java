package main.strategies.add;

import main.Process;

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