import java.util.Scanner;

public class ManajemenRestoran{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL s = new SLL();

        boolean flag = true;

        System.out.println("=== Sistem Manajemen Pesanan Restoran ===");
        System.out.println("1. Tambah Pesanan");
        System.out.println("2. Hapus Pesanan");
        System.out.println("3. Tampilkan Pesanan");
        System.out.println("4. Hitung Pendapatan");
        System.out.println("0. Keluar");
        while (flag) {
            System.out.print("\nPilih menu: ");
            int choice = input.nextInt(); input.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("\nMasukkan nama: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan pesanan: ");
                    String pesanan = input.nextLine();
                    System.out.print("Masukkan harga: ");
                    int harga = input.nextInt(); input.nextLine();

                    Pesanan p = new Pesanan(nama, pesanan, harga);
                    s.tambahPesanan(p);
                    break;
                }

                case 2: {
                    System.out.print("Masukkan nama yang ingin dihapus: " );
                    String nama = input.nextLine();

                    s.hapusPesanan(nama);
                    break;
                }

                case 3: {
                    s.tampilkanSemua();
                    break;
                }

                case 4: {
                    System.out.println("Total Pendapatan: " + s.hitungPendapatan());
                    break;
                }

                case 0: {
                    System.out.println("Terima kasih dan selamat tinggal");
                    flag = false;
                    break;
                }

                default: {
                    System.out.println("Pilihan antara 0-4");
                    flag = false;
                }
            }
        }
    }
}

class Pesanan {
    String nama, menu;
    int total;

    Pesanan (String nama, String menu, int total) {
        this.nama = nama;
        this.menu = menu;
        this.total = total;
    }
}

class Node {
    Pesanan data;
    Node next;

    Node (Pesanan data) {
        this.data = data;
        this.next = null;
    }

}

class SLL {
    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return (size == 0);
    }

    int getSize() {
        return size;
    }

    void tambahPesanan(Pesanan p) {
        Node pesananBaru = new Node(p);

        if (isEmpty()) {
            head = tail = pesananBaru;
        } else {
            tail.next = pesananBaru;
            tail = pesananBaru;
        }
        size++;
    }

    void hapusPesanan(String nama){
        if (isEmpty()) {
            System.err.println("Maaf pesanan memang kosong");
            return;
        }

        if (head.data.nama.equals(nama)) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        while (temp != null){
            if (temp.next.data.nama.equals(nama)){
                temp = temp.next.next;
            }
            temp = temp.next;
        }
        size--;
    }

    void tampilkanSemua() {
        if (isEmpty()) {
            System.err.println("Maaf pesanan memang kosong");
            return;
        }

        Node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            System.out.println(i + ". " + temp.data.nama + " - " + temp.data.menu + " - " + temp.data.total);
            temp = temp.next;
        }
    }

    int hitungPendapatan() {
        if (isEmpty()) {
            System.err.println("Maaf pesanan memang kosong");
            return 0;
        }

        Node temp = head;
        int totalPendapatan = 0;
        while (temp != null){
            totalPendapatan += temp.data.total;
            temp = temp.next;
        }
        return totalPendapatan;
    }
}