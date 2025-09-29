public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList CDLL = new CircularDoublyLinkedList();
        CDLL.addFirst("A");
        CDLL.addFirst("B");
        CDLL.addFirst("C");
        CDLL.addFirst("D");
        CDLL.printHeadToTail("Print Pertama:");
        CDLL.insertAfter("B", new Node("S"));
        CDLL.printHeadToTail("InsertAfter B, sisip S:");
        CDLL.insertBefore("S", new Node("Z"));
        CDLL.printHeadToTail("InsertBefore S, sisip Z:");
        CDLL.insertAt(3, new Node("P"));
        CDLL.printHeadToTail("InsertAt 3, sisip P:");
        CDLL.removeFirst();
        CDLL.printHeadToTail("RemoveFirst, hapus D:");
        CDLL.removeLast();
        CDLL.printHeadToTail("RemoveLast, hapus A:");
        CDLL.remove("P");
        CDLL.printHeadToTail("Remove, hapus P:");
        CDLL.addFirst("Q");
        CDLL.addFirst("W");
        CDLL.addFirst("E");
        CDLL.addFirst("R");
        CDLL.addFirst("T");
        CDLL.addFirst("Y");
        CDLL.addFirst("U");
        CDLL.printHeadToTail("Tambah Data:");
        CDLL.removeAt(1);
        CDLL.printHeadToTail("RemoveAt index 1, hapus Y:");
        System.out.println("Get index 3, return E:");
        System.out.println(CDLL.get(3));
        System.out.println("IndexOf mengecek E, return 3:");
        System.out.println(CDLL.indexOf("E"));
    }
}

class Node {
    Object data;
    Node next, prev;

    Node () {}

    Node (Object data) {
        this.data = data;
    }

    Node (Object data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class CircularDoublyLinkedList {
    Node head, tail;
    int size = 0;

    void initialized() {
        head = tail = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    void addFirst(Object data){
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            head.prev = head;
            head.next = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void addLast(Object data){
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = tail;
            tail.prev = tail;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    void insertAfter(Object data, Node newNode) {
        if (isEmpty()){
            System.err.println("Maaf CDLL masih kosong nih");
            return;
        }

        Node temp = head;
        if (tail.data.equals(data)){
            addLast(newNode);
            return;
        }
        do {
            if (temp.data.equals(data)){
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
                size++;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void insertBefore(Object data, Node newNode){
        if (isEmpty()){
            System.err.println("Maaf CDLL masih kosong nih");
            return;
        }

        Node temp = head;
        if (head.data.equals(data)){
            addFirst(newNode);
            return;
        }
        do {
            if (temp.next.data.equals(data)){
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
                size++;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void insertAt(int index, Node newNode){
        if (isEmpty()){
            System.err.println("Maaf CDLL masih kosong nih");
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++){
            if (i == index - 1) {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
                size++;
            }
            temp = temp.next;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.err.println("Maaf CDLL masih kosong nih!");
            return;
        }

        if (head.equals(tail)) {
            head = tail = null;
        } else {
            tail.next = head.next;
            head.next.prev = tail;
            head = head.next;
        }
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            System.err.println("Maaf CDLL masih kosong nih!");
            return;
        }

        if (head.equals(tail)) {
            head = tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
    }

    void remove(Object data){
        if (isEmpty()){
            System.err.println("Maaf CDLL masih kosong nih!");
            return;
        }

        if (data.equals(head.data)){
            removeFirst();
            return;
        }
        if (data.equals(tail.data)){
            removeLast();
            return;
        }

        Node temp = head;
        do {
            if (temp.next.data.equals(data)){
                temp.next = temp.next.next;
                temp.next.prev = temp;
                size--;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void removeAt(int index){
        if (isEmpty()){
            System.err.println("Maaf CDLL masih kosong nih");
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++){
            if (i == index - 1) {
                temp.next = temp.next.next;
                temp.next.prev = temp;
                size--;
            }
            temp = temp.next;
        }
    }

    Object get(int index){
        if (isEmpty()){
            System.err.println("Maaf CDLL masih kosong nih!");
            return null;
        }

        Node temp = head;
        for (int i = 0; i <= index; i++){
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
        }

        return null;
    }

    int indexOf(Object data){
        int index = 0;
        if (isEmpty()){
            System.err.println("Maaf CDLL masih kosong nih!");
            return -1;
        }

        Node temp = head;
        do {
            if (temp.data.equals(data)){
                return index;
            }
            index++;
            temp = temp.next;
        } while (temp != head);

        return -1;
    }

    void printHeadToTail(String komentar){
        if (isEmpty()) {
            System.err.println("Maaf CDLL masih kosong nih");
            return;
        }

        Node temp = head;
        System.out.println(komentar);
        do {
            System.out.print(temp.data + " - ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

