package main.strategies.add;

import main.Process;

import java.util.List;

public class DefaultAddProcessStrategy implements AddProcessStrategy {
    @Override
    public boolean add(Process process, List<Process> processes, int capacity) {
        return processes.size() < capacity && processes.add(process);
    }
}
