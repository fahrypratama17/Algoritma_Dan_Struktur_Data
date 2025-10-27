public class SubTreeHeight {
    static class Node {
        char value;
        Node left, right;

        Node(char value) {
            this.value = value;
        }
    }

    static int height(Node node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);
        return 1 + (left > right ? left : right);
    }

    static Node find(Node root, char target) {
        if (root == null) return null;
        if (root.value == target) return root;

        Node left = find(root.left, target);
        return (left != null) ? left : find(root.right, target);
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.left.left.left = new Node('F');

        char target = 'B';
        Node sub = find(root, target);
        System.out.println("Tinggi subtree " + target + ": " + height(sub));
    }
}