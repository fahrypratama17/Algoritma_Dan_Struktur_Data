public class HitungNode {
    int data;
    HitungNode left, right;

    HitungNode (int data){
        this.data = data;
    }

    static int countNodes(HitungNode node){
        if (node == null){
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        HitungNode root = new HitungNode(1);
        root.left = new HitungNode(2);
        root.right = new HitungNode(3);
        root.left.left = new HitungNode(4);
        root.left.right = new HitungNode(5);

        System.out.println("Jumlah node: " + countNodes(root));
    }
}