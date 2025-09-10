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
        list.insertAt(2, "J");
        list.removeAt(1);

        list.printSLL();
        System.out.println(list.size());
        System.out.println();
        System.out.println(list.get(1));
        System.out.println(list.get(5));
        System.out.println(list.indexOf("Z"));
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

    void insertBefore(Object targetData, Node newNode) {
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
            System.err.println("Datanya Kosong Nih");
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
            System.err.println("Datanya Kosong Nih");
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
            System.err.println("Datanya Kosong Nih");
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
        System.err.println("Data tidak ditemukan " + targetData);
    }

    void insertAt(int index, Object data) {
        Node newNode = new Node(data);
        if (isEmpty() && index == 0) {
            head = newNode;
            size++;
            return;
        } else if (isEmpty() && index != 0) {
            System.err.println("Waduh, SSL-nya masih kosong mas");
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (i != index - 1) {
                temp = temp.next;
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
        }
    }

    void removeAt(int index) {
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    Object get(int index) {
        if (index < 0) {
            System.err.println("Index tidak boleh kurang dari 0");
            return null;
        } else if (index >= size) {
            System.err.println("Input melebihi maksimum index");
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    int indexOf (Object data) {
        Node temp = head;
        int index = 0;

        while (temp != null) {

            if (temp.data.equals((data))) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public void printSLL() {
        Node temp = head;
        if (isEmpty()) {
            System.err.println("Datanya Kosong Nih");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            if (temp == null) System.out.print("Null");
        }
        System.out.println();
    }
}



