package main.strategies.list;

import main.Process;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListByPriorityStrategy implements ListStrategy {
    @Override
    public List<Process> list(List<Process> processes) {
        return processes.stream()
                .sorted(Comparator.comparing(Process::getPriority))
                .collect(Collectors.toList());
    }
}