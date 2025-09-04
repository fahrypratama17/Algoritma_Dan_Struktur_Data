public class Main {
    Node head, tail;
    int size = 0;

    public static void main(String[] args) {
        Node head = new Node("A", "I");
        Node tail = new Node("B");
    }
}

class Node {
    Object data;
    Node next;

    Node (Object data) {
        this.data = data;
    }

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}



