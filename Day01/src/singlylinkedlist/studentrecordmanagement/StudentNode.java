package src.singlylinkedlist.studentrecordmanagement;

public class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    // Constructor
    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}
