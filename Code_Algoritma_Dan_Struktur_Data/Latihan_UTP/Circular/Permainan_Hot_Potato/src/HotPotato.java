import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CSLL cs= new CSLL();

        System.out.println("=== Permainan Hot Potato ===");
        System.out.println("1. Tambah Pemain");
        System.out.println("2. Mainkan");
        System.out.println("3. Tampilkan Pemenang");
        System.out.println("0. Keluar");

        boolean flag = true;

        while (flag) {
            System.out.print("\nPilih menu: ");
            int choice = input.nextInt(); input.nextLine();
            switch (choice){
                case 1: {
                    System.out.print("\nMasukkan nama pemain: ");
                    Pemain p = new Pemain(input.nextLine());

                    cs.tambahPemain(p);
                    break;
                }

                case 2: {
                    System.out.print("Berapa kali memainkan? ");
                    cs.mainkan(input.nextInt());
                    break;
                }

                case 3: {
                    cs.tampilkanPemenang();
                    break;
                }

                case 0: {
                    System.out.println("Keluar dari program...");
                    System.out.println("Terima kasih dan Sampai Jumpa");
                    flag = false;
                }

                default: {
                    System.out.println("Pilihan hanya dari 0-3");
                    flag = false;
                }
            }
        }
    }
}

class Pemain {
    String nama;

    Pemain (String nama){
        this.nama = nama;
    }
}

class Node {
    Pemain data;
    Node next;

    Node (Pemain data){
        this.data = data;
        this.next = null;
    }
}

class CSLL {
    Node head, tail, pemenang;
    int size;

    boolean isEmpty() {
        return (size == 0);
    }

    int getSize() {
        return size;
    }

    void tambahPemain(Pemain p) {
        Node pemainBaru = new Node(p);

        if (isEmpty()){
            head = tail = pemainBaru;
            head.next = head;
        } else {
            tail.next = pemainBaru;
            tail = pemainBaru;
            pemainBaru.next = head;
            pemenang = head;
        }
        size++;
    }


    void mainkan(int hitungan){
        if (isEmpty()){
            System.out.println("Maaf tidak ada pemenang!!!");
            return;
        }

        Node temp = head;
        for (int i = 1; i <= hitungan; i++){
            temp = temp.next;
            if (i == hitungan){
                pemenang = temp;
            }
        }
    }

    void tampilkanPemenang(){
        if (isEmpty()){
            System.out.println("Maaf tidak ada pemenang!!!");
            return;
        }

        System.out.println("Pemenangnnya adalah: " + pemenang.data.nama);
    }
}
