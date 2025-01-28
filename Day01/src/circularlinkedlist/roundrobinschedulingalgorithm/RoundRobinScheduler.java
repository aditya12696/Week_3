package src.circularlinkedlist.roundrobinschedulingalgorithm;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinScheduler {
    private ProcessNode head;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            ProcessNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode current = head, prev = null;

        // If the head needs to be removed
        if (head.processId == processId) {
            if (head.next == head) {
                head = null; // Only one process in the list
            } else {
                ProcessNode tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                head = head.next;
                tail.next = head;
            }
            return;
        }

        // Search for the process to remove
        do {
            prev = current;
            current = current.next;
            if (current.processId == processId) {
                prev.next = current.next;
                break;
            }
        } while (current != head);
    }

    // Simulate round-robin scheduling
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        List<Integer> waitingTimes = new ArrayList<>();
        List<Integer> turnAroundTimes = new ArrayList<>();
        ProcessNode current = head;
        int time = 0;

        System.out.println("Starting Round Robin Scheduling...");

        while (true) {
            boolean allProcessesCompleted = true;
            ProcessNode prev = null;

            do {
                if (current.burstTime > 0) {
                    allProcessesCompleted = false;
                    int executionTime = Math.min(current.burstTime, timeQuantum);
                    System.out.println("Process ID " + current.processId + " executed for " + executionTime + " units.");
                    time += executionTime;
                    current.burstTime -= executionTime;

                    // If the process completes
                    if (current.burstTime == 0) {
                        System.out.println("Process ID " + current.processId + " completed.");
                        turnAroundTimes.add(time);
                        waitingTimes.add(time - (current.priority)); // Original burst time stored in priority field for calculation
                        removeProcess(current.processId);
                        if (prev != null) prev.next = current.next;
                    }
                }
                prev = current;
                current = current.next;
            } while (current != head);

            if (allProcessesCompleted) break;

            System.out.println("Processes after this round:");
            displayProcesses();
        }

        calculateAndDisplayAvgTimes(waitingTimes, turnAroundTimes);
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode current = head;
        do {
            System.out.println("Process ID=" + current.processId + ", Remaining Burst Time=" + current.burstTime);
            current = current.next;
        } while (current != head);
    }

    // Calculate and display average waiting and turn-around times
    private void calculateAndDisplayAvgTimes(List<Integer> waitingTimes, List<Integer> turnAroundTimes) {
        double totalWaitingTime = 0;
        double totalTurnAroundTime = 0;

        for (int waitingTime : waitingTimes) {
            totalWaitingTime += waitingTime;
        }

        for (int turnAroundTime : turnAroundTimes) {
            totalTurnAroundTime += turnAroundTime;
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / waitingTimes.size()));
        System.out.println("Average Turn-Around Time: " + (totalTurnAroundTime / turnAroundTimes.size()));
    }
}