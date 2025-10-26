public class DeleteBST {
    int data;
    DeleteBST left, right;

    DeleteBST(int data) {
        this.data = data;
    }

    void insert(int val){
        if (val < data){
            if (left == null) {
                left = new DeleteBST(val);
            } else {
                left.insert(val);
            }
        } else if (val > data) {
            if (right == null){
                right = new DeleteBST(val);
            } else {
                right.insert(val);
            }
        }
    }

    static DeleteBST delete(DeleteBST root, int val){
        if (root == null){
            return null;
        }

        if (val < root.data){
            root.right = delete(root.right, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    static int minValue(DeleteBST node){
        int min = node.data;

        while (node.left != null){
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    static void inorder(DeleteBST node){
        if (node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[] data = {50, 30, 70, 20, 40, 60, 80};
        DeleteBST root = new DeleteBST(data[0]);

        for (int i = 1; i < data.length; i++){
            root.insert(data[i]);
        }

        root = delete(root, 30);
        System.out.print("Inorder setelah hapus: ");
        inorder(root);
    }
}