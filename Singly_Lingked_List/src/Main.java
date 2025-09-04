public class Main {

    public static void main(String[] args) {
        Node list = new Node();

        System.out.println("Head " + list.printSLL);
    }
}

class Node {
    Object data;
    Node next;

    Node head, tail;
    int size = 0;

    Node () {}

    Node (Object data) {
        this.data = data;
    }

    Node (Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    void intialized () {
        head = tail = null;
    }

    boolean isEmpty () {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst (Object data) {
        Node item = new Node(data);
        if (isEmpty() ) {
            head = item;
            tail = item;
        } else {
            item.next = head;
            head = item;
        }
        size++;
    }

    void addLast (Object data) {
        Node item = new Node(data);
        if (isEmpty()) {
            head = tail = item;
        } else {
            tail.next = item;
            tail = item;
        }
        size++;
    }

    public void printSLL() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("Kosong nih");
        } while (temp != null) {
            System.out.println(temp.data = " - ");
            temp = temp.next;
        }
    }
}



