package src.singlylinkedlist.studentrecordmanagement;

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Add student records
        studentList.addAtBeginning(101, "Adi", 20, "A");
        studentList.addAtEnd(102, "Diven", 22, "B");
        studentList.addAtPosition(2, 103, "Charlie", 21, "A+");

        // Display all students
        System.out.println("All Students:");
        studentList.displayAll();

        // Search for a student by Roll Number
        System.out.println("\nSearching for Roll Number 102:");
        studentList.searchByRollNumber(102);

        // Update a student's grade
        System.out.println("\nUpdating grade for Roll Number 103:");
        studentList.updateGrade(103, "A");

        // Display all students after the update
        System.out.println("\nAll Students After Grade Update:");
        studentList.displayAll();

        // Delete a student record
        System.out.println("\nDeleting student with Roll Number 101:");
        studentList.deleteByRollNumber(101);

        // Display all students after deletion
        System.out.println("\nAll Students After Deletion:");
        studentList.displayAll();
    }
}

