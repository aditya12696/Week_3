package src.singlylinkedlist.inventorymanagementsystem;

public class InventoryLinkedList {
    private InventoryNode head;

    public InventoryLinkedList() {
        head = null;
    }

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        InventoryNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 1 || head == null) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        InventoryNode current = head;
        int count = 1;

        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Remove item by Item ID
    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("No items in the inventory to remove.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed successfully.");
            return;
        }

        InventoryNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed successfully.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {
        InventoryNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for item by ID or Name
    public void searchItem(String searchTerm) {
        InventoryNode current = head;
        boolean found = false;

        while (current != null) {
            // Check if search term is numeric or a string
            if (isNumeric(searchTerm)) {
                // Search by Item ID
                if (current.itemId == Integer.parseInt(searchTerm)) {
                    System.out.println("Found Item: Name=" + current.itemName + ", ID=" + current.itemId + ", Quantity=" + current.quantity + ", Price=" + current.price);
                    found = true;
                }
            } else {
                // Search by Item Name
                if (current.itemName.equalsIgnoreCase(searchTerm)) {
                    System.out.println("Found Item: Name=" + current.itemName + ", ID=" + current.itemId + ", Quantity=" + current.quantity + ", Price=" + current.price);
                    found = true;
                }
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No items found matching the search term: " + searchTerm);
        }
    }

    // Helper method to check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Calculate total value of inventory
    public void calculateTotalValue() {
        InventoryNode current = head;
        double totalValue = 0;

        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }

        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }

        System.out.println("Inventory Items:");
        InventoryNode current = head;
        while (current != null) {
            System.out.println("Name=" + current.itemName + ", ID=" + current.itemId + ", Quantity=" + current.quantity + ", Price=" + current.price);
            current = current.next;
        }
    }
}
