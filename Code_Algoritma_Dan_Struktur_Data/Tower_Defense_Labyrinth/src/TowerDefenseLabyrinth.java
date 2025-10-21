// ---------------------------------------------
// Tugas 1 - Tower Defense Labyrinth
// ---------------------------------------------

import java.util.Scanner;

public class TowerDefenseLabyrinth {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        int sizeLabirin = Integer.parseInt(input.nextLine());
        Labirin lab = new Labirin(sizeLabirin);

        String bisaDilalui = input.nextLine();
        String[] koordinatBD = bisaDilalui.split(" ");
        int[][] arrayBD = new int[koordinatBD.length][2];
        int count = 0;

        for (String s : koordinatBD) {
            if (s.contains(",")) {
                String[] xy = s.split(",");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                arrayBD[count][0] = x;
                arrayBD[count][1] = y;
                count++;
            }
        }

        Koordinat start = new Koordinat(arrayBD[0][0], arrayBD[0][1]);
        Koordinat finish = new Koordinat(arrayBD[count - 1][0], arrayBD[count - 1][1]);

        lab.setBisaDilalui(arrayBD, count);
        lab.setStartFinish(start, finish);
        lab.cetakLabirin();
    }
}

// Ini bagian untuk menyesuaikan dengan detil spesifikasi program ke-1
class Labirin {
    int size;
    String[][] areaLabirin;
    Koordinat start, finish;

    Labirin(int size) {
        this.size = size;
        areaLabirin = new String[size][size];

        for (int i = 0; i < areaLabirin.length; i++){
            for (int j = 0; j < areaLabirin[i].length; j++){
                areaLabirin[i][j] = "[XX]";
            }
        }
    }

    void setBisaDilalui(int[][] koordinatJalur, int count) {
        for (int i = 0; i < count; i++) {
            int x = koordinatJalur[i][0];
            int y = koordinatJalur[i][1];
            if (x >= 0 && x < size && y >= 0 && y < size) {
                areaLabirin[y][x] = "[00]";
            }
        }
    }

    void setStartFinish(Koordinat start, Koordinat finish) {
        this.start = start;
        this.finish = finish;
        areaLabirin[start.y][start.x] = "[ST]";
        areaLabirin[finish.y][finish.x] = "[FN]";
    }

    void cetakLabirin(){
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                System.out.print(areaLabirin[i][j]);
            }
            System.out.println();
        }
    }
}

class Koordinat {
    int x, y;

    Koordinat(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class NodePemain {
    Pemain data;
    NodePemain next;

    NodePemain(Pemain data){
        this.data = data;
        this.next = null;
    }
}

class NodePQ {
    Pemain data;
    NodePQ next;

    NodePQ(Pemain data){
        this.data = data;
    }
}

class QueuePemain {
    NodePemain front, rear;
    int size;

    boolean isEmpty(){
        return (front == null);
    }

    int getSize() {
        return size;
    }

    void enqueue(Pemain data){
        NodePemain pemainBaru = new NodePemain(data);
        if (rear == null){
            front = rear = pemainBaru;
        } else {
            rear.next = pemainBaru;
            rear = pemainBaru;
        }
    }

    Pemain dequeue() {
        if (isEmpty()){
            return null;
        }
        front = front.next;
        if (isEmpty()){
            rear = null;
        }
        size--;
        return front.data;
    }
}

class PriorityQueue {
    NodePQ head;
    int size;

    boolean isEmpty() {
        return (head == null);
    }

    int getSize() {
        return size;
    }

    void enqueue(Pemain data){
        NodePQ pemainBaru = new NodePQ(data);
        if (isEmpty() || data.lebihBaikDari(head.data)){
            pemainBaru.next = head;
            head = pemainBaru;
        } else {
            NodePQ sekarang = head;
            while (sekarang.next != null && !data.lebihBaikDari(sekarang.next.data)) {
                sekarang = sekarang.next;
            }
            pemainBaru.next = sekarang.next;
            sekarang.next = pemainBaru;
        }
        size++;
    }

    Pemain dequeue(){
        if (isEmpty()){
            return null;
        }
        Pemain data = head.data;
        head = head.next;
        size--;
        return data;
    }

}

class Pemain  {
    String nama;
    String[] gerakan;
    int jmlLangkah = 0;
    boolean finish = false;
    int[][] lintasan;

    Pemain(String nama, String[] gerakan){
        this.nama = nama;
        this.gerakan = gerakan;
    }

    boolean lebihBaikDari(Pemain lain) {
        if (this.jmlLangkah < lain.jmlLangkah) {
            return true;
        }
        if (this.jmlLangkah == lain.jmlLangkah) {
            return this.nama.compareTo(lain.nama) < 0;
        }
        return false;
    }
}