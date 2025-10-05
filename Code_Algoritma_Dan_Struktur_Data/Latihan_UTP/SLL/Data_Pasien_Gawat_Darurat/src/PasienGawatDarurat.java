import java.util.Scanner;

public class PasienGawatDarurat{
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        SLL s = new SLL();

        System.out.println("=== Data Pasien Gawat Darurat ===");
        System.out.println("1. Tambah Pasien");
        System.out.println("2. Tampilkan Pasien");
        System.out.println("0. Keluar");

        boolean flag = true;
        while (flag){
            System.out.print("\nPilih menu: ");
            int choice = input.nextInt(); input.nextLine();
            switch (choice){
                case 1: {
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan tingkatan: ");
                    int tingkat = input.nextInt(); input.nextLine();

                    Pasien p = new Pasien(nama, tingkat);
                    s.tambahPasien(p);
                    break;
                }

                case 2: {
                    s.tampilkanPasien();
                    break;
                }

                case 0: {
                    System.out.println("Keluar dari program...");
                    System.out.println("Terima kasih dan Selamat Tinggal");
                    break;
                }

                default: {
                    System.out.println("Pilihan dari 0-2");
                    flag = false;
                }
            }
        }

    }
}

class Pasien {
    String nama;
    int tingkat;

    Pasien(String nama, int tingkat){
        this.nama = nama;
        this.tingkat = tingkat;
    }
}

class Node {
    Pasien data;
    Node next;

    Node (Pasien data){
        this.data = data;
        this.next = null;
    }
}

class SLL {
    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    void tambahPasien(Pasien p) {
        Node pasienBaru = new Node(p);

        if (isEmpty()) {
            head = tail = pasienBaru;
            size++;
            return;
        }

        if (pasienBaru.data.tingkat > head.data.tingkat){
            pasienBaru.next = head;
            head = pasienBaru;
            size++;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data.tingkat >= pasienBaru.data.tingkat){
            temp = temp.next;
        }
        pasienBaru.next = temp.next;
        temp.next = pasienBaru;

        if (pasienBaru.next == null){
            tail = pasienBaru;
        }
        size++;
    }

    void tampilkanPasien() {
        if (isEmpty()){
            System.err.println("Daftar Pasien Kosong!");
            return;
        }

        System.out.println("Urutan prioritas:");
        Node temp = head;
        int i = 0;
        while (temp != null){
            i++;
            System.out.println(i + ". " + temp.data.nama + " - " + temp.data.tingkat);
            temp = temp.next;
        }
    }
}