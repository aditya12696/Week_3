package src.circularlinkedlist.onlineticketreservationsystem;

public class TicketReservationSystem {
    private Node last;

    public TicketReservationSystem() {
        this.last = null;
    }

    // Add a new ticket reservation at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Node newNode = new Node(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Node current = last.next, previous = last;

        do {
            if (current.ticketId == ticketId) {
                if (current == last.next && current == last) { // Only one node in the list
                    last = null;
                } else {
                    if (current == last.next) { // Removing the first node
                        last.next = current.next;
                    } else if (current == last) { // Removing the last node
                        previous.next = last.next;
                        last = previous;
                    } else { // Removing a middle node
                        previous.next = current.next;
                    }
                }
                System.out.println("Ticket ID " + ticketId + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        Node current = last.next;
        System.out.println("Ticket List:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName +
                    ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchValue) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        Node current = last.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchValue) || current.movieName.equalsIgnoreCase(searchValue)) {
                System.out.println("Ticket Found: Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName +
                        ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found for " + searchValue + ".");
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        if (last == null) {
            return 0;
        }

        int count = 0;
        Node current = last.next;
        do {
            count++;
            current = current.next;
        } while (current != last.next);

        return count;
    }
}
