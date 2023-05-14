package main.java.com.owt.taskmanager.strategies.list;

import main.java.com.owt.taskmanager.Process;

import java.util.List;

public class ListByCreationTimeStrategy implements ListStrategy {
    @Override
    public List<Process> list(List<Process> processes) {
        return processes;
    }
}