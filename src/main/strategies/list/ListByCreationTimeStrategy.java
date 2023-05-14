package main.strategies.list;

import main.Process;

import java.util.List;

public class ListByCreationTimeStrategy implements ListStrategy {
    @Override
    public List<Process> list(List<Process> processes) {
        return processes;
    }
}