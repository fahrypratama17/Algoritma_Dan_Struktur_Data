import java.util.Scanner;

public class RoadPoneglyph {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jumlah = input.nextInt();
        int[] infoPoneglyph = new int[jumlah];

        for (int i = 0; i < jumlah; i++){

        }

        SLL list = new SLL();
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

class SLL {
    Node head, tail;
    int size;

    void initialized() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int getSize() {
        return size;
    }

    void addFirst(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        }
        newNode.next = newNode;
    }

    void printSLL() {
        if (isEmpty()) {
            System.err.println("Waduhhh, SLL-nya masih kosong nih!!!");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }
    }
}