package main.java.com.owt.taskmanager;

public class Process {
    private final String pid;
    private final Priority priority;

    public Process(String pid, Priority priority) {
        this.pid = pid;
        this.priority = priority;
    }

    public String getPid() {
        return pid;
    }

    public Priority getPriority() {
        return priority;
    }

    public void kill() {
        System.out.printf("Process %s has been killed.\n", pid);
    }

    @Override
    public String toString() {
        return String.format("Process[%s, %s]", pid, priority);
    }
}