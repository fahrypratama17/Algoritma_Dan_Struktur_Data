public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst("A");
        list.addLast("B");
        list.printHeadToTail();
        list.printTailToHead();
        System.out.println("Size: " + list.size() + "\n");

        list.insertAfter("B", new Node("C"));
        list.insertBefore("A", new Node("Z"));
        list.printHeadToTail();
        list.printTailToHead();
        System.out.println("Size: " + list.size() + "\n");

        list.removeFirst();
        list.removeLast();
        list.printHeadToTail();
        list.printTailToHead();
        System.out.println("Size: " + list.size() + "\n");

        list.insertAfter("B", new Node("C"));
        list.insertBefore("A", new Node("Z"));
        list.remove("A");
        list.insertAt(3, "D");
        list.printHeadToTail();
        list.printTailToHead();
        System.out.println("Size: " + list.size() + "\n");

        list.removeAt(3);
        System.out.println(list.get(1));
        list.printHeadToTail();
        list.printTailToHead();
        System.out.println("Size: " + list.size() + "\n");

        System.out.println(list.indexOf("Z"));
        System.out.println(list.indexOf("H"));
    }
}

class Node {
    Object data;Node next;Node prev;

    public Node() { }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data,Node next,Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    Node head = null, tail = null;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) addFirst(data);
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void insertAfter (Object data, Node newNode) {
        if (isEmpty()) return;

        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                newNode.next = temp.next;
                newNode.prev = temp;
                if (temp.next != null) {
                    temp.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                temp.next = newNode;
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    void insertBefore (Object data, Node newNode) {
        if (isEmpty()) return;

        if (head.data.equals(data)) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
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
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
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
            tail = tail.prev;
            tail.next = null;
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

        Node temp = head.next;
        while (temp != null) {
            if (temp.data.equals(targetData)) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
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
            head = tail = newNode;
            size++;
            return;
        } else if (isEmpty() && index != 0) {
            System.err.println("Datanya Kosong Nih");
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }

        if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (i != index - 1) {
                temp = temp.next;
            } else {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
                size++;
                return;
            }
        }
    }

    void removeAt(int index) {
        if (index < 0) {
            System.err.println("Index tidak boleh kurang dari 0");
        } else if (index >= size) {
            System.err.println("Input melebihi maksimum index");
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
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
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

    public void printHeadToTail() {
        Node temp = head;
        System.out.print("Null <-> ");
        while (temp != null ) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void printTailToHead() {
        Node temp = tail;
        System.out.print("Null <-> ");
        while (temp != null ) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Null");
    }
}