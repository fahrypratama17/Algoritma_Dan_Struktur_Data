public class Node {
    Object data;
    Node next;

    public static void main(String[] args) {
        Node head = new Node(); // Untuk A
        head.data = "A"; // Untuk D
        System.out.println("Data: " + head.data); // Untuk B
        System.out.println("Pointer: " + head.next); // Untuk C
        System.out.println();

        SLL list = new SLL();
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
        list.addLast(new Node());
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
        list.addLast(new Node());
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
        list.addLast(new Node());
        System.out.println("head : " + list.head);
        System.out.println("tail : " + list.tail);
    }
}

class SLL {
    Node head, tail;
    int size = 0;

    void initialized() {
        head = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if(isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if(isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }
}
