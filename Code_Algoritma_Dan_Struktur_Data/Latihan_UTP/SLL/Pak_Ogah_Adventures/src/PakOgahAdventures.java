import java.util.Scanner;

public class PakOgahAdventures {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL s = new SLL();

        int banyakGua = input.nextInt(); input.nextLine();
        for (int i = 0; i < banyakGua; i++){
            String baris = input.nextLine();
            String[] angkaStr = baris.split(" ");

            SLL barisAngkaGua = new SLL();

            for (String angka : angkaStr) {
                float nilai = Float.parseFloat(angka);
                barisAngkaGua.addLast(new Gua(nilai));
            }

            float maks = barisAngkaGua.getMax();
            barisAngkaGua.addMax(s, maks);
        }

        float total = s.total();
        float hasil = total/banyakGua;
        System.out.printf("%.2f", hasil);
    }
}

class Gua {
    float angka;

    Gua (float angka){
        this.angka = angka;
    }
}

class Node {
    Gua data;
    Node next;

    Node (Gua data){
        this.data = data;
        this.next = null;
    }
}

class SLL {
    Node head, tail;
    int angka = 0;
    int size = 0;

    boolean isEmpty(){
        return (size == 0);
    }

    int getSize(){
        return size;
    }

    void addLast(Gua g) {
        Node angkaGua = new Node(g);

        if (isEmpty()){
            head = tail = angkaGua;
        } else {
            tail.next = angkaGua;
            tail = angkaGua;
        }
        size++;
    }

    float getMax(){
        if (isEmpty()) return 0;

        Node temp = head;
        float maks = temp.data.angka;

        while (temp != null){
            if (temp.data.angka > maks){
                maks = temp.data.angka;
            }
            temp = temp.next;
        }
        return maks;
    }

    void addMax(SLL s, float maks){
        Node temp = head;

        while (temp != null){
            if (temp.data.angka == maks){
                s.addLast(new Gua(maks));
            }
            temp = temp.next;
        }
    }

    float total(){
        Node temp = head;
        float total = 0;

        while (temp != null){
            total += temp.data.angka;
            temp = temp.next;
        }
        return total;
    }
}