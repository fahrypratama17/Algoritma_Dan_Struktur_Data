public class Node {
    Object data;
    Node next;
    Node prev;

    public static void main(String[] args) {
        DLL list = new DLL();
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

class DLL {
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
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }
}