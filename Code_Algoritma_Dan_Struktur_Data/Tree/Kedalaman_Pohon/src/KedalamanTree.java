public class KedalamanTree {
    int data;
    KedalamanTree left, right;

    KedalamanTree(int data) {
        this.data = data;
    }

    static int getDepth(KedalamanTree node) {
        if (node == null){
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return  1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        KedalamanTree root = new KedalamanTree(1);
        root.left = new KedalamanTree(2);
        root.right = new KedalamanTree(3);
        root.left.left = new KedalamanTree(4);
        root.left.right = new KedalamanTree(5);

        System.out.println("Kedalaman pohon: " + getDepth(root));
    }
}