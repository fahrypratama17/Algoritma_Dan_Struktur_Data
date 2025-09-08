public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("S");
        list.addLast("I");
        list.insertAfter("S" , new Node("B"));
        list.insertBefore("B", new Node("K"));
        list.insertAfter("B", new Node("L"));
        list.insertAfter("L", new Node("P"));
        list.insertAfter("L", new Node("F"));
        list.insertAfter("K", new Node("Z"));
        list.insertAfter("Z", new Node("K"));
        list.insertAfter("K", new Node("O"));
        list.removeFirst();
        list.removeLast();
        list.printSLL();
        System.out.println(list.size());
        list.remove("B");
        list.printSLL();
        System.out.println(list.size());
        list.remove("F");

        list.printSLL();
        System.out.println(list.size());
    }
}

class Node {
    Object data;
    Node next;

    Node () {}

    Node (Object data) {
        this.data = data;
    }

    Node (Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class SinglyLinkedList {
    Node head, tail;
    int size = 0;

    void initialization () {
        head = tail = null;
    }

    boolean isEmpty () {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst (Object targetData) {
        Node newNode = new Node(targetData);
        if (isEmpty() ) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addLast (Object targetData) {
        Node newNode = new Node(targetData);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void insertAfter(Object targetData, Node newNode) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(targetData)) {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    void insertBefore(Object targetData, Node input) {
        Node newNode = input;

        if (isEmpty()) {
            return;
        }

        if (head.data.equals(targetData)) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(targetData)) {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Datanya Kosong Nih");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Datanya Kosong Nih");
            return;
        }
        if (head == tail) {
            head = tail = null;
        }
        else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }

    void remove(Object targetData) {
        if (isEmpty()) {
            System.out.println("Datanya Kosong Nih");
            return;
        }

        if (head.data.equals(targetData)) {
            removeFirst();
            return;
        }

        if (tail.data.equals(targetData)) {
            removeLast();
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(targetData)) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
                size--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Data tidak ditemukan " + targetData);
    }

    public void printSLL() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("Datanya Kosong nih");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" - ");
            temp = temp.next;
        }
        System.out.println();
    }
}



