public class Main {
    public static void main(String[] args) {
        StackLinkedList Stack = new StackLinkedList();

        Stack.pushStack(new Node(1));
        Stack.pushStack(new Node(2));
        Stack.pushStack(new Node(3));
        Stack.pushStack(new Node(4));
        Stack.pushStack(new Node(5));
        Stack.pushStack(new Node(6));
        Stack.pushStack(new Node(7));
        Stack.pushStack(new Node(8));

        System.out.println(Stack.peekStack());
        Stack.popStack();
        System.out.println(Stack.peekStack());
    }
}

class Node {
    int data;
    Node next;

    Node() {}

    Node (int data){
        this.data = data;
    }

    Node (int data, Node pointer){
        this.data = data;
        this.next = pointer;
    }
}

class StackLinkedList {
    Node head, tail, top;

    void initialized() {
        head = tail = top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    int popStack(){
        if (isEmpty()){
            System.err.println("Stack kosong nih");
            return -1;
        }

        int tampungData = top.data;
        removeLast();
        top = tail;
        return tampungData;
    }

    void removeLast() {
        Node temp = head;
        if (tail.equals(head)){
            head = tail = null;
        } else {
            while (!temp.next.equals(tail)){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            temp = null;
        }
    }

    void pushStack(Node data){
        addLast(data);
        top = tail;
    }

    void addLast(Node data){
        if (isEmpty()) {
            head = tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
    }

    int peekStack(){
        return top.data;
    }
}