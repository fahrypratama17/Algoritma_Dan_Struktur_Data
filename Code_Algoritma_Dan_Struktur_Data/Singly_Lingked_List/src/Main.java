public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("A");
        list.addLast("B");
        list.printSLL();
        System.out.println("Size: " + list.size() + "\n");

        list.insertAfter("B", new Node("C"));
        list.insertBefore("A", new Node("Z"));
        list.printSLL();
        System.out.println("Size: " + list.size() + "\n");

        list.removeFirst();
        list.removeLast();
        list.printSLL();
        System.out.println("Size: " + list.size() + "\n");

        list.insertAfter("B", new Node("C"));
        list.insertBefore("A", new Node("Z"));
        list.remove("A");
        list.insertAt(3, "D");
        list.printSLL();
        System.out.println("Size: " + list.size() + "\n");

        list.removeAt(3);
        System.out.println(list.get(1));
        list.printSLL();
        System.out.println("Size: " + list.size() + "\n");

        System.out.println(list.indexOf("Z"));
        System.out.println(list.indexOf("H"));
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
    Node head, tail = null;
    int size = 0;

    boolean isEmpty () {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst (Object data) {
        Node newNode = new Node(data);
        if (isEmpty() ) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addLast (Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void insertAfter(Object data, Node newNode) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == tail) {
                    tail = newNode;
                }
                size++;
                return;
            }
            temp = temp.next;
        }
        System.err.println("Data tidak ditemukan " + data);
    }

    void insertBefore(Object data, Node newNode) {
        if (isEmpty()) {
            System.err.println("Datanya Kosong Nih");
            return;
        }

        if (head.data.equals(data)) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(data)) {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
        System.err.println("Data tidak ditemukan " + data);
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

    void remove(Object data) {
        if (isEmpty()) {
            System.err.println("Datanya Kosong Nih");
            return;
        }

        if (head.data.equals(data)) {
            removeFirst();
            return;
        }

        if (tail.data.equals(data)) {
            removeLast();
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(data)) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
                size--;
                return;
            }
            temp = temp.next;
        }
        System.err.println("Data tidak ditemukan " + data);
    }

    void insertAt(int index, Object data) {
        Node newNode = new Node(data);
        if (isEmpty() && index == 0) {
            head = tail = newNode;
            size++;
            return;
        } else if (isEmpty() && index != 0) {
            System.err.println("Datanya Kosong Nih");
            return;
        }

        if (index < 0) {
            System.err.println("Index tidak boleh kurang dari 0");
            return;
        } else if (index > size) {
            System.err.println("Input melebihi maksimum index");
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (i != index - 1) {
                temp = temp.next;
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
                size++;
                return;
            }
        }
    }

    void removeAt(int index) {
        if (index < 0) {
            System.err.println("Index tidak boleh kurang dari 0");
            return;
        } else if (index >= size) {
            System.err.println("Input melebihi maksimum index");
            return;
        }

        if (index == 0 ) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

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