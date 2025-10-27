public class PathCount {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    static int countPaths(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countPaths(root.left) + countPaths(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Jumlah jalur akar ke daun: " + countPaths(root));
    }
}