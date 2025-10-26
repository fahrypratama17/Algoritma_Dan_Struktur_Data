public class BST {
    int data;
    BST left, right;

    BST(int data){
        this.data = data;
    }

    void insert(int value){
        if (value < data){
            if (left == null){
                left = new BST(value);
            } else {
                left.insert(value);
            }
        } else if (value > data) {
            if (right == null){
                right = new BST(value);
            } else {
                right.insert(value);
            }
        }
    }

    void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.print(data + " ");
        if (right != null){
            right.inorder();
        }
    }

    public static void main(String[] args) {
        int[] nilai = {50, 60, 70, 20, 30, 40, 10, 100, 90, 80};
        BST root = new BST(nilai[0]);

        for (int i = 1; i < nilai.length; i++){
            root.insert(nilai[i]);
        }

        System.out.print("Inorder traversal: ");
        root.inorder();
    }
}