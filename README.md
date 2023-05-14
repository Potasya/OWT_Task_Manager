### Task Manager
This project implements a simple Task Manager.

## Features
- Add a process (a process is an object with a unique ID and a priority level (LOW, MEDIUM, HIGH)).
    - Different behavior for adding a process when the limit is reached:
        - Default: If the max size is reached, it won’t accept any new processes, keeping the old ones and rejecting the new arrivals.
        - FIFO (First-In, First-Out): If the max size is reached, it will remove the oldest (first added) process and allow the new process to be added.
        - Priority: If the max size is reached, it will remove the lowest priority existing process older than the new one to be added and will add the new one, in case it has a higher priority. If the priorities are the same, it will remove the older process.
- List all processes.
- Kill 
  - a specific process.
  - all processes.
  - all processes with a specific priority.


