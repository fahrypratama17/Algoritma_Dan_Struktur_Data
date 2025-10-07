import java.sql.SQLOutput;
import java.util.Scanner;

public class NavigasiBrowser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLL d = new DLL();

        System.out.println("=== Riwayat Navigasi Browser ===");
        System.out.println("1. Buka Situs");
        System.out.println("2. Maju");
        System.out.println("3. Mundur");
        System.out.println("4. Tampilkan AKtif");
        System.out.println("0. Keluar");

        boolean flag = true;

        while (flag){
            System.out.print("\nPilih menu: ");
            int choice  = input.nextInt(); input.nextLine();
            switch (choice){
                case 1: {
                    System.out.print("\nMasukkan url: ");
                    String url = input.nextLine();

                    Browser b = new Browser(url);
                    d.bukaSitus(b);
                    break;
                }

                case 2: {
                    d.maju();
                    break;
                }

                case 3: {
                    d.mundur();
                    break;
                }

                case 4: {
                    d.tampilkanAktif();
                    break;
                }

                case 0: {
                    System.out.println("Keluar dari program...");
                    System.out.println("Terima kasih dan Sampai Jumpa!!!");
                    flag = false;
                }

                default: {
                    System.out.println("Pilihan hanya dari 0-4");
                    flag = false;
                }
            }
        }
    }
}

class Browser {
    String url;

    Browser (String url) {
        this.url = url;
    }
}

class Node {
    Browser data;
    Node next, prev, current;

    Node (Browser data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    Node head, tail, current;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    void bukaSitus(Browser b){
        Node browserBaru = new Node(b);

        if (isEmpty()){
            head = tail = current = browserBaru;
            size++;
            return;
        }

        tail.next = browserBaru;
        browserBaru.prev = tail;
        tail = current =  browserBaru;
        current.next = null;
        current.prev = tail.prev;
        size++;
    }

    void maju() {
        if (isEmpty()){
            System.err.println("Browser sudah ditutup!!!");
            return;
        }

        if (current.next == null){
            System.out.println(current.data.url + " sudah paling depan");
        } else {
            current = current.next;
        }
    }

    void mundur() {
        if (isEmpty()){
            System.err.println("Browser sudah ditutup!!!");
            return;
        }

        if (current.prev == null){
            System.out.println(current.data.url + " sudah paling belakang");
        } else {
            current = current.prev;
        }
    }

    void tampilkanAktif() {
        if (isEmpty()){
            System.err.println("Browser sudah ditutup!!");
            return;
        }

        System.out.print("\nSekarang aktif: " + current.data.url);
    }
}