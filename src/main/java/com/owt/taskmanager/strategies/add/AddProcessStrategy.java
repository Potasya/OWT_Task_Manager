package main.java.com.owt.taskmanager.strategies.add;

import main.java.com.owt.taskmanager.Process;

import java.util.List;

public interface AddProcessStrategy {
    boolean add(Process process, List<Process> processes, int capacity);
}
