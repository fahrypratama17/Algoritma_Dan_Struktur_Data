public class NodeLevel {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Queue {
        Node[] arr = new Node[100];
        int front = 0, rear = 0;

        boolean isEmpty() {
            return front == rear;
        }

        int size() {
            return rear - front;
        }

        void add(Node n) {
            arr[rear++] = n;
        }

        Node poll() {
            return arr[front++];
        }
    }

    static int countLevel(Node root, int level) {
        if (root == null) {
            return 0;
        }
        Queue q = new Queue();
        q.add(root);
        int currLevel = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            if (currLevel == level) {
                return size;
            }

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            currLevel++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Jumlah node di level 3: " + countLevel(root, 3));
    }
}