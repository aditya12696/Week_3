package src.singlylinkedlist.studentrecordmanagement;

public class StudentLinkedList {
    private StudentNode head;

    // Add a student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add a student at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add a student at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Record deleted successfully.");
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Record not found.");
            return;
        }
        current.next = current.next.next;
        System.out.println("Record deleted successfully.");
    }

    // Search for a student by roll number
    public void searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Record Found: " + current);
                return;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
    }

    // Update a student's grade
    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
