public class LeafNode {
    int data;
    LeafNode left, right;

    LeafNode(int data) {
        this.data = data;
    }

    static int countLeaf(LeafNode node){
        if (node == null){
            return 0;
        }

        if (node.left == null && node.right == null){
            return 1;
        }

        return countLeaf(node.left) + countLeaf(node.right);
    }

    public static void main(String[] args) {
        LeafNode root = new LeafNode(1);
        root.left = new LeafNode(2);
        root.right = new LeafNode(3);
        root.left.left = new LeafNode(4);
        root.right.left = new LeafNode(5);
        root.right.right = new LeafNode(6);

        System.out.println("Jumlah node daun: " + countLeaf(root));
    }
}