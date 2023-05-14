package main.java.com.owt.taskmanager.strategies.list;

import main.java.com.owt.taskmanager.Process;

import java.util.List;

public interface ListStrategy {
    List<Process> list(List<Process> processes);
}
