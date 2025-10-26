public class pohonKeluarga {
    Node root;

    void preorder(Node node){
        if (node != null){
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void main(String[] args) {
        pohonKeluarga tree = new pohonKeluarga();
        tree.root = new Node("A");
        tree.root.left = new Node("B");
        tree.root.right = new Node("C");
        tree.root.left.left = new Node("D");
        tree.root.left.right = new Node("E");
        tree.root.right.left = new Node("F");
        tree.root.left.right = new Node("G");

        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
    }
}

class Node {
    String data;
    Node left, right;

    Node (String data) {
        this.data = data;
        left = right = null;
    }
}