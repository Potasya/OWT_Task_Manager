package main.strategies.add;

import main.Process;

import java.util.List;

public class PriorityBasedAddProcessStrategy implements AddProcessStrategy {
    @Override
    public boolean add(Process process, List<Process> processes, int capacity) {
        if (processes.size() < capacity) {
            return processes.add(process);
        } else {
            for (Process p : processes) {
                if (p.getPriority().ordinal() < process.getPriority().ordinal()) {
                    processes.remove(p);
                    return processes.add(process);
                }
            }
        }
        return false;
    }
}