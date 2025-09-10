public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst("A");
        list.addFirst("B");
        list.addLast("C");
        list.insertAfter("A", new Node("K"));
        list.insertBefore("B", new Node("L"));

        list.printHeadToTail();
        list.printTailToHead();
        System.out.println("Size: " + list.size());
    }
}

class Node {
    Object data;Node next;Node prev;

    public Node() { }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data,Node next,Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList { Node head, tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) addFirst(data);
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void insertAfter (Object data, Node newNode) {
        if (isEmpty()) return;

        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                newNode.next = temp.next;
                newNode.prev = temp;
                if (temp.next != null) {
                    temp.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    void insertBefore (Object data, Node newNode) {
        if (isEmpty()) return;

        if (head.data.equals(data)) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }



    public void printHeadToTail() {
        Node temp = head;
        System.out.print("Null <-> ");
        while (temp != null ) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void printTailToHead() {
        Node temp = tail;
        System.out.print("Null <-> ");
        while (temp != null ) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Null");
    }
}