public class QueueLinkedList {
    public static void main(String[] args) {
        QLL q = new QLL();

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");

        System.out.println("Front: " + q.peek());
        q.print();
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Front setelah dequeue: " + q.peek());
        q.print();
    }
}

class Node {
    Object data;
    Node next;

    public Node(Object data){
        this.data = data;
        this.next = null;
    }
}

class QLL {
    Node front, rear;
    int size;

    QLL() {
        front = rear = null;
        size = 0;
    }

    boolean isEmpty() {
        return front == null;
    }

    int getSize() {
        return size;
    }

    void enqueue(Object data){
        Node newNode = new Node(data);

        if (rear == null){
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    Object dequeue() {
        if (isEmpty()){
            System.err.println("Queue kosong.");
            return null;
        }

        front = front.next;

        if (front.equals(null)){
            rear = null;
        }
        size--;
        return front.data;
    }

    Object peek() {
        if (isEmpty()) {
            System.err.println("Queue kosong.");
            return null;
        }

        return front.data;
    }

    void print() {
        if (isEmpty()) {
            System.err.println("Queue kosong.");
        }

        Node temp = front;
        System.out.print("Antrian: ");
        while (temp != null) {
            System.out.print(temp.data + " - ");
            temp = temp.next;
        }
    }
}