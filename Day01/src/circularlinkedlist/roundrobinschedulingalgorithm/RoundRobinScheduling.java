package src.circularlinkedlist.roundrobinschedulingalgorithm;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Time quantum is 4

        // Adding processes to the queue
        scheduler.addProcess(1, 10, 10); // Process ID, Burst Time, Priority
        scheduler.addProcess(2, 5, 5);
        scheduler.addProcess(3, 8, 8);
        scheduler.addProcess(4, 12, 12);

        // Display initial processes
        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        // Simulate scheduling
        System.out.println("\nSimulating Round Robin Scheduling:");
        scheduler.simulateScheduling();
    }
}
