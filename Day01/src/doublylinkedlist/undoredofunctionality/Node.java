package src.doublylinkedlist.undoredofunctionality;

class Node {
    String state; // State of the text
    Node prev, next;

    public Node(String state) {
        this.state = state;
        this.prev = null;
        this.next = null;
    }
}
