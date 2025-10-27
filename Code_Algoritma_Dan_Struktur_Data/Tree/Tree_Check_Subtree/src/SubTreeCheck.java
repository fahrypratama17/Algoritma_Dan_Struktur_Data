public class SubTreeCheck {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    static boolean isSame(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.value == b.value) && isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    static boolean isSubtree(Node main, Node sub) {
        if (main == null) return false;
        if (isSame(main, sub)) return true;
        return isSubtree(main.left, sub) || isSubtree(main.right, sub);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(2);
        root2.left = new Node(4);
        root2.right = new Node(5);

        System.out.println(isSubtree(root1, root2) ? "Pohon 2 adalah subtree dari Pohon 1." : "Bukan subtree.");
    }
}