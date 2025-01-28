package src.circularlinkedlist.taskscheduler;
public class TaskCircularList {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode current;

    public TaskCircularList() {
        head = null;
        tail = null;
        current = null;
    }

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode current = head;
        int count = 1;

        while (current.next != head && count < position - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }
    }

    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        TaskNode current = head;
        TaskNode prev = tail;

        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Task with ID " + taskId + " removed successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }

        if (current != null) {
            System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName + ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
            current = current.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("All Tasks:");
        TaskNode current = head;
        do {
            System.out.println("ID=" + current.taskId + ", Name=" + current.taskName + ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode current = head;
        boolean found = false;

        do {
            if (current.priority == priority) {
                System.out.println("Found Task: ID=" + current.taskId + ", Name=" + current.taskName + ", Due Date=" + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with Priority " + priority);
        }
    }
}
