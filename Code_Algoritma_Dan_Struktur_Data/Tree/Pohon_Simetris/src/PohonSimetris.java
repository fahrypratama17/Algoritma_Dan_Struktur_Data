public class PohonSimetris {
    static class Node {
        int value;
        Node left, right;

        Node (int value) {
            this.value = value;
        }
    }

    static boolean isMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.value == b.value) && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println("Pohon simetris: " + (isMirror(root.left, root.right) ? "Ya" : "Tidak"));
    }
}