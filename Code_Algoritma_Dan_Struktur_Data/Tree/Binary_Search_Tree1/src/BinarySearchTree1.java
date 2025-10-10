public class BinarySearchTree1 {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] data = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int d : data){
            bst.insert(d);
        }

        System.out.print("Inorder BST: ");
        bst.inOrder(bst.root);
    }
}

class Node {
    int key;
    Node left, right;

    Node(int k) {
        key = k;
    }
}

class BST {
    Node root;

    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node node, int key){
        if (node == null){
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key){
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }
}