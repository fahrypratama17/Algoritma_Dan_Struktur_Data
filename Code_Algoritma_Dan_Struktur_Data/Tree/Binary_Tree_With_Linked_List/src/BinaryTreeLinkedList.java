public class BinaryTreeLinkedList {
    public static void main(String[] args) {
        LinkedBinnaryTree tree = new LinkedBinnaryTree();

        tree.root = new Node("A");
        tree.root.left = new Node("B");
        tree.root.right = new Node("C");
        tree.root.left.left = new Node("D");
        tree.root.left.right = new Node("E");
        tree.root.right.right = new Node("F");

        System.out.print("Preorder: ");
        tree.preOrder(tree.root);
        System.out.print("\nInorder: ");
        tree.inOrder(tree.root);
        System.out.print("\nPostorder: ");
        tree.postOrder(tree.root);
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

class LinkedBinnaryTree {
    Node root;

    // --- TRAVERSAL ---
    void preOrder(Node node){
        if (node != null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}