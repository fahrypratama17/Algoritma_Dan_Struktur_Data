public class SumTree {
    int data;
    SumTree left, right;

    SumTree(int data) {
        this.data = data;
    }

    static int sum(SumTree node) {
        if (node == null) {
            return 0;
        }

        return node.data + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        SumTree root = new SumTree(10);
        root.left = new SumTree(5);
        root.right = new SumTree(15);
        root.left.left = new SumTree(3);
        root.left.right = new SumTree(7);

        System.out.println("Jumlah seluruh node = " + sum(root));
    }
}