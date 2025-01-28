package src.circularlinkedlist.taskscheduler;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskCircularList taskList = new TaskCircularList();

        // Adding tasks
        taskList.addAtBeginning(1, "Task A", 1, "2025-01-25");
        taskList.addAtEnd(2, "Task B", 3, "2025-01-26");
        taskList.addAtPosition(2, 3, "Task C", 2, "2025-01-27");

        // Display all tasks
        taskList.displayAllTasks();

        // View current task and move to the next
        System.out.println();
        taskList.viewCurrentTask();
        taskList.viewCurrentTask();
        taskList.viewCurrentTask();

        // Search by priority
        System.out.println();
        taskList.searchByPriority(2);

        // Remove a task by Task ID
        System.out.println();
        taskList.removeByTaskId(2);

        // Display all tasks after removal
        System.out.println();
        taskList.displayAllTasks();
    }
}
