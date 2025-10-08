public class ArrayBinnaryTree {
    public static void main(String[] args) {
        ABT t = new ABT(10);
        t.setRoot("A");
        t.setLeft("B", 0);
        t.setRight("C", 0);
        t.setLeft("D", 1);
        t.setRight("E", 1);
        t.setLeft("F", 2);

        t.printTree();
    }
}

class ABT {
    String[] tree;
    int size;

    ABT(int size) {
        this.size = size;
        tree = new String[size];
    }

    void setRoot(String data) {
        tree[0] = data;
    }

    void setLeft(String data, int parentIndex){
        int left = 2 * parentIndex + 1;
        if (left < size) {
            tree[left] = data;
        }
    }

    void setRight(String data, int parentIndex){
        int right = 2 * parentIndex + 2;
        if (right < size) {
            tree[right] = data;
        }
    }

    void printTree() {
        for (int i = 0; i < size; i++){
            System.out.println("Index " + i + ": " + tree[i]);
        }
    }
}