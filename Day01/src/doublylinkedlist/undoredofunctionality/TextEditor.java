package src.doublylinkedlist.undoredofunctionality;

public class TextEditor {
    private Node head, tail, current;
    private final int MAX_HISTORY; // Maximum undo/redo history size
    private int size;

    public TextEditor(int maxHistory) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.MAX_HISTORY = maxHistory;
        this.size = 0;
    }

    // Add a new state at the end
    public void addState(String newState) {
        Node newNode = new Node(newState);

        // If there's a redo path, discard it
        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
        }

        // Add the new state
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        current = newNode;
        size++;

        // Remove oldest state if history exceeds limit
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Undo not possible.");
            return;
        }
        current = current.prev;
        System.out.println("Undo: Current State -> " + current.state);
    }

    // Redo functionality
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Redo not possible.");
            return;
        }
        current = current.next;
        System.out.println("Redo: Current State -> " + current.state);
    }

    // Display the current state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No current state.");
        } else {
            System.out.println("Current State: " + current.state);
        }
    }
}
