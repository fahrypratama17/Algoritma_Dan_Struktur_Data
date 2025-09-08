public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("S");
        list.addLast("I");
        list.insertAfter("S" , new Node("B"));
        list.insertBefore("B", new Node("K"));
        list.insertAfter("B", new Node("L"));
        list.removeFirst();
        list.removeLast();
        list.remove("B");

        list.printSLL();
        System.out.println(list.size);
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

    void intialization () {
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
            System.out.println("Data Kosong Nih");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head)
                head = tail = null;
            else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                temp = null;
            }
            size--;
        }
        else
            System.out.println("Data Kosong Nih");
    }

    void remove(Object targetData) {
        Node temp = head;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.next.data.equals(targetData)) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                        return;
                    } else if ((temp.data == targetData) && (temp == head)) {
                        this.removeFirst();
                        return;
                    }
                }
            }
        } else
            System.out.println("Data Kosong Nih");
    size--;
    }


    public void printSLL() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("data Kosong nih");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " - ");
            temp = temp.next;
        }
        System.out.println();
    }
}



