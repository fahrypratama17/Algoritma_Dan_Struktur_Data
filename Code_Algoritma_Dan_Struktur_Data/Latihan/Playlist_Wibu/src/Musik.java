import java.util.Scanner;

public class Musik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Playlist listP = new Playlist();

        int jml1 = input.nextInt();
        for (int i = 0; i < jml1; i++){
            String title = input.next();
            listP.addEnd(title);
        }

        int jml2 = input.nextInt();

        for (int i = 0; i < jml2; i++) {
            String pilihan = input.next();

            switch (pilihan) {
                case "ADD_END": {
                    String title = input.next();
                    listP.addEnd(title);
                    break;
                }
                case "ADD_BEGIN": {
                    String title = input.next();
                    listP.addBegin(title);
                    break;
                }
                case "ADD_AFTER": {
                    int idx = input.nextInt();
                    String title = input.next();
                    listP.addAfter(idx, title);
                    break;
                }
                case "REMOVE": {
                    int idx = input.nextInt();
                    listP.remove(idx);
                    break;
                }
                case "PLAY": {
                    int idx = input.nextInt();
                    listP.play(idx);
                    break;
                }
                case "NEXT": {
                    listP.next();
                    break;
                }
                case "PREV": {
                    listP.prev();
                    break;
                }
                case "SEARCH": {
                    String title = input.next();
                    System.out.println(listP.search(title));
                    break;
                }
                case "PRINT": {
                    listP.print();
                    break;
                }
            }
        }
    }
}

class Node {
    String title;
    Node next, prev;

    Node () {}

    Node (String title) {
        this.title = title;
    }

    Node (String title, Node next, Node prev) {
        this.title = title;
        this.next = next;
        this.prev = prev;
    }
}

class Playlist {
    Node head;
    Node tail;
    Node current;
    int size = 0;

    Playlist (){}

    boolean isEmpty() {
        return size == 0;
    }

    void addEnd(String title){
        Node song = new Node(title);
        if (isEmpty()) {
            head = tail = song;
        } else {
            tail.next = song;
            song.prev = tail;
            tail = song;
        }
        size++;
    }

    void addBegin(String title){
        Node song = new Node(title);
        if (isEmpty()) {
            head = tail = song;
        } else {
            song.next = head;
            head.prev = song;
            head = song;
        }
        size++;
    }

    void addAfter(int idx, String title){
        Node song = new Node(title);
        Node temp = head;
        for (int i = 0; i <= idx; i++){
            if (temp == null) return;
            if (temp.equals(tail)){
                addEnd(title);
                return;
            }
            if (i == idx) {
                song.next = temp.next;
                song.prev = temp;
                if (temp.next != null) {
                    temp.next.prev = song;
                }
                temp.next = song;
            }
            temp = temp.next;
        }
        size++;
    }

    void remove(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++){
            if (temp == null) return;
            temp = temp.next;
        }

        if (temp.equals(current)){
            if (temp.next != null) {
                current = temp.next;
            } else if (temp.prev != null) {
                current = temp.prev;
            } else {
                current = null;
            }
        }

        if (temp == head && temp == tail) {
            head = tail = null;
        } else if (temp == head){
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        size--;
    }

    void play(int idx){
        Node temp = head;
        for (int i = 0; i <= idx; i++) {
            if (i == idx) {
                current = temp;
            }
            temp = temp.next;
        }
    }

    void next(){
        if (current != null && current.next != null){
            current = current.next;
        }
    }

    void prev(){
        if (current != null && current.prev != null){
            current = current.prev;
        }
    }

    int search(String title){
        Node temp = head;
        int idx = 0;
        while (temp != null){
            if (temp.title.equals(title)){
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            if (temp.equals(current)){
                System.out.println("*" + temp.title);
            } else {
                System.out.println(temp.title);
            }
            temp = temp.next;
        }
    }
}

