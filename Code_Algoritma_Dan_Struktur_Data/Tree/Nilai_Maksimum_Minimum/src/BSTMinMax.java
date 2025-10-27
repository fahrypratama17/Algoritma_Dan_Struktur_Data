public class BSTMinMax {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    static int findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    static int findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {
        int[] arr = {50, 30, 70, 20, 40, 60, 80};
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        System.out.println("Nilai minimum: " + findMin(root));
        System.out.println("Nilai maksimum: " + findMax(root));
    }
}