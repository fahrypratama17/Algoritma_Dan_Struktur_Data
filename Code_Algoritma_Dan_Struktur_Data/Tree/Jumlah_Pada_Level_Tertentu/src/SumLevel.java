public class SumLevel {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
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

        void add(Node node) {
            arr[rear++] = node;
        }

        Node poll() {
            return arr[front++];
        }
    }

    static int sumAtLevel(Node root, int target) {
        if (root == null) {
            return 0;
        }
        Queue q = new Queue();

        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (level == target) sum += node.value;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (level == target) return sum;
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(20);
        root.left.left = new Node(5);
        root.left.right = new Node(10);
        root.right.right = new Node(25);
        System.out.println("Total di level 2: " + sumAtLevel(root, 2));
    }
}