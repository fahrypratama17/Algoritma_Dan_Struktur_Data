public class PohonLengkap {
    static class Node {
        int data;
        Node left, right;

        Node (int data) {
            this.data = data;
        }
    }

    static class Queue {
        Node[] arr = new Node[100];
        int front = 0, rear = 0;

        boolean isEmpty() {
            return front == rear;
        }

        void add(Node n) {
            arr[rear++] = n;
        }

        Node poll() {
            return arr[front++];
        }
    }

    static boolean isComplete(Node root) {
        if (root == null) {
            return true;
        }

        Queue q = new Queue();
        q.add(root);
        boolean end = false;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println("Pohon lengkap: " + (isComplete(root) ? "Ya" : "Tidak"));
    }
}