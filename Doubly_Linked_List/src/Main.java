import java.sql.SQLOutput;

public class DoublyLinkedList {
    DoublyNode head, tail;
    int size;

    public static void main(String[] args) {
        DoublyNode dll = new DoublyLinkedList();
        dll.addFirst("0");
    }

    public DoublyLinkedList() {
        this.makeEmpty();
    }

    public void makeEmpty() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst() {

    }

    public void printToTail() {
        DoublyNode p =head;
        while (p != null ) {
            System.out.println(p.data + " - ");
            p = p.prev;
        }

    }
}

class DoublyNode {
    Object data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode() {

    }

    public DoublyNode(Object data, DoublyNode next, DoublyNode prev) {

    }
}