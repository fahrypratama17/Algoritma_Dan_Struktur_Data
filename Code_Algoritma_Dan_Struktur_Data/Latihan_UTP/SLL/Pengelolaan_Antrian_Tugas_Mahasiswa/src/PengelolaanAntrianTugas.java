import java.util.Scanner;

public class PengelolaanAntrianTugas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL s = new SLL();

        System.out.println("=== Sistem Pengelolaan Antrian Tugas ===");
        System.out.println("1. Tambah Tugas Baru");
        System.out.println("2. Tandai Tugas Selesai");
        System.out.println("3. Hapus Tugas Yang Sudah Selesai");
        System.out.println("4. Tampilkan Tugas");
        System.out.println("0. Keluar");

        boolean flag = true;

        while (flag) {
            System.out.print("\nPilih menu: ");
            int choice = input.nextInt(); input.nextLine();
            switch (choice){
                case 1: {
                    System.out.print("\nMasukkan Tugas: ");
                    String tugas = input.nextLine();
                    System.out.print("Masukkan Deadline: ");
                    String deadline = input.nextLine();

                    Tugas t = new Tugas(tugas, deadline);
                    s.tambahTugas(t);
                    break;
                }

                case 2: {
                    System.out.print("Tugas Selesai: ");
                    String tugas = input.nextLine();
                    s.selesaikanTugas(tugas);
                    break;
                }

                case 3: {
                    s.hapusSelesai();
                    break;
                }

                case 4: {
                    s.tampilkanSemua();
                    break;
                }

                case 0: {
                    System.out.println("Keluar dari program...");
                    System.out.println("Terima kasih dan Selamat Tinggal");
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

class Tugas {
    String judul, deadline;
    String status;

    Tugas(String judul, String deadline){
        this.judul = judul;
        this.deadline = deadline;
        this.status = "BELUM SELESAI";
    }
}

class Node {
    Tugas data;
    Node next;

    Node(Tugas data){
        this.data = data;
        this.next = null;
    }
}

class SLL {
    Node head, tail;
    int size;

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    void tambahTugas(Tugas t){
        Node tugasBaru = new Node(t);

        if (isEmpty()){
            head = tail = tugasBaru;
            size++;
            return;
        }

        tail.next = tugasBaru;
        tail = tugasBaru;
        size++;
    }

    void selesaikanTugas(String tugas){
        if (isEmpty()) {
            System.err.println("Kamu tidak memiliki tugas.");
            return;
        }

        Node temp = head;
        while (temp != null){
            if (temp.data.judul.equals(tugas)){
                temp.data.status = "SELESAI";
            }
            temp = temp.next;
        }
    }

    void hapusSelesai() {
        if (isEmpty()) {
            System.err.println("Kamu memang tidak memiliki tugas.");
            return;
        }

        if (head.data.status.equals("SELESAI")){
            head = head.next;
            size--;
        }

        if (head == null) {
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != null){
            if (temp.next.data.status.equals("SELESAI")){
                temp.next = temp.next.next;
                size--;
                if (temp.next == null){
                    tail = temp;
                }
            } else {
                temp = temp.next;
            }
        }
    }

    void tampilkanSemua() {
        if (isEmpty()) {
            System.err.println("Kamu tidak memiliki tugas.");
            return;
        }

        Node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            System.out.println(i + ". " + temp.data.judul + " - " + temp.data.deadline + " - " + temp.data.status);
            temp = temp.next;
        }
    }
}

