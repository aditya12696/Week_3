package src.circularlinkedlist.onlineticketreservationsystem;

class Node {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Node next;

    public Node(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
