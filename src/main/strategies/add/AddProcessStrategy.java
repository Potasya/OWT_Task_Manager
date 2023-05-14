package main.strategies.add;

import main.Process;

import java.util.List;

public interface AddProcessStrategy {
    boolean add(Process process, List<Process> processes, int capacity);
}
