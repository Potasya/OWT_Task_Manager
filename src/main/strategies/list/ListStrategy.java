package main.strategies.list;

import main.Process;

import java.util.List;

public interface ListStrategy {
    List<Process> list(List<Process> processes);
}
