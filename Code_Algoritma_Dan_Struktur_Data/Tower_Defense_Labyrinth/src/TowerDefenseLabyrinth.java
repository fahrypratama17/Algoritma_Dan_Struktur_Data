// ---------------------------------------------
// Tugas 1 - Tower Defense Labyrinth
// ---------------------------------------------

public class TowerDefenseLabyrinth {
    public static void main(String[] args) {

    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.next = null;
    }
}

class Queue<T> {
    Node<T> front;
    Node<T> rear;
    int size;
}

class PriorityQueue<T extends Comparable<T>> {
    Node<T> head;
    int size;
}

class Koordinat {
    int x, y;

    Koordinat(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Pemain implements Comparable<Pemain> {
    String nama;
    String[] gerakan;
    int jmlLangkah = 0;
    boolean finish = false;
    int[][] lintasan;

    Pemain(String nama, String[] gerakan){
        this.nama = nama;
        this.gerakan = gerakan;
    }

    @Override
    public int compareTo(Pemain pemainLain){
        if (this.jmlLangkah != pemainLain.jmlLangkah){
            return Integer.compare(this.jmlLangkah, pemainLain.jmlLangkah);
        }
        return this.nama.compareTo(pemainLain.nama);
    }
}

class Labirin {
    int size;
    int[][] bisaDilewati;
    Koordinat start, finish;

}