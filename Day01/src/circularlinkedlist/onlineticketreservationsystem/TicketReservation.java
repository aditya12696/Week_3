package src.circularlinkedlist.onlineticketreservationsystem;

public class TicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add tickets
        system.addTicket(101, "Adi", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Johan", "Interstellar", "B2", "1:00 PM");
        system.addTicket(103, "Char", "Inception", "A2", "10:00 AM");

        // Display all tickets
        system.displayTickets();

        // Search tickets by Customer Name or Movie Name
        system.searchTicket("Alice");
        system.searchTicket("Inception");

        // Remove a ticket
        system.removeTicket(102);

        // Display all tickets after removal
        system.displayTickets();

        // Display total number of tickets
        System.out.println("Total Tickets: " + system.getTotalTickets());
    }
}
