public class LevelOrderBinaryTree {
    Node root;

    void levelOrder(Node node){
        if (node == null){
            return;
        }

        SimpleQueue q = new SimpleQueue(50);
        q.enqueue(node);

        while(!q.isEmpty()){
            Node current = q.dequeue();
            System.out.print(current.data + " ");

            if (current.left != null){
                q.enqueue(current.left);
            }
            if (current.right != null){
                q.enqueue(current.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderBinaryTree tree = new LevelOrderBinaryTree();

        tree.root = new Node("A");
        tree.root.left = new Node("B");
        tree.root.right = new Node("C");
        tree.root.left.left = new Node("D");
        tree.root.left.right = new Node("E");
        tree.root.right.left = new Node("F");
        tree.root.right.right = new Node("G");

        System.out.print("Level Order Traversal: ");
        tree.levelOrder(tree.root);

    }
}

class Node {
    String data;
    Node left, right;

    Node(String data){
        this.data = data;
        left = right = null;
    }
}

class SimpleQueue {
    private Node[] arr;
    private int front, rear, size;

    SimpleQueue(int capacity){
        arr = new Node[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty(){
        return (size == 0);
    }

    void enqueue(Node node){
        if (rear == arr.length - 1){
            System.out.println("Queue Penuh!!!");
            return;
        }
        arr[++rear] = node;
        size++;
    }

    Node dequeue(){
        if (isEmpty()){
            return null;
        }
        Node temp = arr[front++];
        size--;
        return temp;
    }
}