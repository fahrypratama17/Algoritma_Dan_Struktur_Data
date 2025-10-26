public class CariBST {
    int data;
    CariBST left, right;

    CariBST(int data){
        this.data = data;
    }

    void insert(int val) {
        if (val < data){
            if (left == null){
                left = new CariBST(val);
            } else {
                left.insert(val);
            }
        } else if (val > data){
            if (right == null){
                right = new CariBST(val);
            } else {
                right.insert(val);
            }
        }
    }

    boolean search(int val){
        if (val == data) {
            return true;
        }

        if (val < data) {
            return left != null && left.search(val);
        }

        return right != null && right.search(val);
    }

    public static void main(String[] args) {
        int[] data = {50, 30, 70, 20, 40, 60, 80};
        CariBST root = new CariBST(data[0]);

        for (int i = 0; i < data.length; i++){
            root.insert(data[i]);
        }

        int cari = 40;
        System.out.println(root.search(cari)
            ? cari + " ditemukan di dalam tree."
            : cari + " tidak ditemukan.");
    }
}