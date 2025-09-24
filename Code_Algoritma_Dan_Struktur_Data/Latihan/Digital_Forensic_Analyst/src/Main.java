import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLL listT = new DLL();

        int jml = input.nextInt();

        for (int i = 0; i < jml; i++) {
            String pilihan = input.next();

            switch (pilihan) {
                case "OPEN": {
                    Tersangka t = new Tersangka(input.next(), input.next());
                    listT.open(t);
                    break;
                }
                case "OPEN_FRONT": {
                    Tersangka t = new Tersangka(input.next(), input.next());
                    listT.openFront(t);
                    break;
                }
                case "CLOSE": {
                    String id = input.next();
                    listT.close(id);
                    break;
                }
                case "CLOSE_LEFT": {
                    listT.closeLeft();
                    break;
                }
                case "CLOSE_RIGHT": {
                    listT.closeRight();
                    break;
                }
                case "SHOW_FRONT": {
                    listT.showFront();
                    break;
                }
                case "SHOW_BACK": {
                    listT.showBack();
                    break;
                }
            }
        }
    }
}

class Node {
    Tersangka data;
    Node next, prev;

    Node () {}

    Node (Tersangka data) {
        this.data = data;
    }

    Node (Tersangka data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class Tersangka {
    String id, title;

    Tersangka(String id, String title) {
        this.id = id;
        this.title = title;
    }
}

class DLL {
    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    void open(Tersangka data) {
        Node newT = new Node(data);

        if (isEmpty()) {
            head = tail = newT;
        } else {
            tail.next = newT;
            newT.prev = tail;
            tail = newT;
        }
        size++;
    }

    void openFront(Tersangka data) {
        Node newT = new Node(data);

        if (isEmpty()) {
            head = tail = newT;
        } else {
            newT.next = head;
            head.prev = newT;
            head = newT;
        }
        size++;
    }

    void closeLeft() {
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    void closeRight() {
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    void close(String id) {

        if(head.data.id.equals(id)) {
            closeLeft();
            return;
        }
        if(tail.data.id.equals(id)){
            closeRight();
            return;
        }

        Node temp = head;
        while (temp != null) {
            if(temp.data.id.equals(id)){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    void showFront() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data.id + "-" +temp.data.title + " ");
            temp = temp.next;
        }
    }

    void showBack() {
        if (isEmpty()) {
            System.out.println("EMPTY");
            return;
        }

        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data.id + "-" +temp.data.title + " ");
            temp = temp.prev;
        }
    }
}
