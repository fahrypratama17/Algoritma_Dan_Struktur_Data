public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList CSLL = new CircularSinglyLinkedList();
        CSLL.addFirst("A");
        CSLL.addFirst("B");
        CSLL.addFirst("C");
        CSLL.addFirst("D");
        CSLL.print("Print Pertama:");
        CSLL.insertAfter("B", new Node("S"));
        CSLL.print("InsertAfter B, sisip S:");
        CSLL.insertBefore("S", new Node("Z"));
        CSLL.print("InsertBefore S, sisip Z:");
        CSLL.insertAt(3, new Node("P"));
        CSLL.print("InsertAt 3, sisip P:");
        CSLL.removeFirst();
        CSLL.print("RemoveFirst, hapus D:");
        CSLL.removeLast();
        CSLL.print("RemoveLast, hapus A:");
        CSLL.remove("P");
        CSLL.print("Remove, hapus P:");
        CSLL.addFirst("Q");
        CSLL.addFirst("W");
        CSLL.addFirst("E");
        CSLL.addFirst("R");
        CSLL.addFirst("T");
        CSLL.addFirst("Y");
        CSLL.addFirst("U");
        CSLL.print("Tambah Data:");
        CSLL.removeAt(1);
        CSLL.print("RemoveAt index 1, haput Y:");
        System.out.println("Get index 3, return E:");
        System.out.println(CSLL.get(3));
        System.out.println("IndexOf mengecek E, return 3:");
        System.out.println(CSLL.indexOf("E"));
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

class CircularSinglyLinkedList {
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
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    void addLast(Object data){
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    void insertAfter(Object data, Node newNode) {
        if (isEmpty()){
            System.err.println("Maaf CSLL masih kosong nih");
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
                temp.next = newNode;
                size++;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void insertBefore(Object data, Node newNode){
        if (isEmpty()){
            System.err.println("Maaf CSLL masih kosong nih");
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
                temp.next = newNode;
                size++;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void insertAt(int index, Node newNode){
        if (isEmpty()){
            System.err.println("Maaf CSLL masih kosong nih");
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++){
            if (i == index - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
            }
            temp = temp.next;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.err.println("Maaf CSLL masih kosong nih!");
            return;
        }

        if (head.equals(tail)) {
            head = tail = null;
        } else {
            tail.next = head.next;
            head = head.next;
        }
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            System.err.println("Maaf CSLL masih kosong nih!");
            return;
        }

        Node temp = head;
        if (head.equals(tail)) {
            head = tail = null;
            size--;
            return;
        }

        do {
            if (temp.next.equals(tail)){
                temp.next = head;
                tail = temp;
                size--;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void remove(Object data){
        if (isEmpty()){
            System.err.println("Maaf CSLL masih kosong nih!");
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
                size--;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    void removeAt(int index){
        if (isEmpty()){
            System.err.println("Maaf CSLL masih kosong nih");
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++){
            if (i == index - 1) {
                temp.next = temp.next.next;
                size--;
            }
            temp = temp.next;
        }
    }

    Object get(int index){
        if (isEmpty()){
            System.err.println("Maaf CSLL masih kosong nih!");
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
            System.err.println("Maaf CSLL masih kosong nih!");
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

    void print(String komentar){
        if (isEmpty()) {
            System.err.println("Maaf CSLL masih kosong nih");
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

