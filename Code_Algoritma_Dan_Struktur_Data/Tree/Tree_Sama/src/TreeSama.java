public class TreeSama {
    int data;
    TreeSama left, right;

    TreeSama(int data){
        this.data = data;
    }

    static boolean isSame(TreeSama a, TreeSama b){
        if (a == null && b == null){
            return true;
        }
        if (a == null || b == null){
            return false;
        }

        return (a.data == b.data) && isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeSama t1 = new TreeSama(2);
        t1.left = new TreeSama(1);
        t1.right = new TreeSama(3);

        TreeSama t2 = new TreeSama(2);
        t2.left = new TreeSama(1);
        t2.right = new TreeSama(3);

        System.out.println(isSame(t1, t2)
            ? "Kedua pohon sama."
            : "Kedua pohon berbeda.");
    }
}