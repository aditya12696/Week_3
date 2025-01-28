package src.singlylinkedlist.inventorymanagementsystem;

public class InventoryManagement {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        // Adding items to inventory
        inventory.addAtBeginning("Laptop", 101, 5, 1200.50);
        inventory.addAtEnd("Smartphone", 102, 10, 800.00);
        inventory.addAtPosition(2, "Tablet", 103, 7, 400.75);

        // Display inventory
        inventory.displayInventory();

        // Update quantity
        System.out.println();
        inventory.updateQuantityById(102, 15);

        // Search for an item
        System.out.println();
        inventory.searchItem("102"); // Search by ID
        inventory.searchItem("Laptop"); // Search by Name

        // Calculate total value
        System.out.println();
        inventory.calculateTotalValue();

        // Remove an item
        System.out.println();
        inventory.removeById(103);

        // Display inventory after removal
        System.out.println();
        inventory.displayInventory();
    }
}
