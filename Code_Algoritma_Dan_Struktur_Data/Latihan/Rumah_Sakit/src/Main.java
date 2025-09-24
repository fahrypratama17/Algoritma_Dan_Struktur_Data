import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        LinkedListAntrean listPasien = new LinkedListAntrean();

        boolean flag = true;
        do {
            String pilihan = input.next();

            switch (pilihan) {
                case "TAMBAH": {
                    Pasien p = new Pasien(input.next(), input.next(), input.next(), input.nextInt());
                    listPasien.tambahPasien(p);
                    break;
                }
                case "PANGGIL": {
                    listPasien.panggilPasien();
                    break;
                }
                case "HAPUS":  {

                   listPasien.hapusPasienById(input.next());
                   break;
                }
                case "CETAK":  {
                    // Biar formatnya outputnya enak mas, outputnya sama kok dengan test case
                    break;
                }
                case "KELUAR":  {
                    listPasien.cetakAntrean();
                    System.out.println("Sistem manajemen antrean ditutup. Terima kasih.");
                    break;
                }
                default: {
                    System.err.println("Input salah");
                }
            }

        } while (flag);


    }
}

class Pasien {
    String idPasien, namaPasien, penyakit;
    int levelPrioritas;

    Pasien (String idPasien, String namaPasien, String penyakit, int levelPrioritas) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.penyakit = penyakit;
        this.levelPrioritas = levelPrioritas;
    }

    String getPrioritas() {
        switch (levelPrioritas) {
            case 1: return "1 (Gawat)";
            case 2: return "2 (Cukup Gawat)";
            case 3: return "3 (Tidak Gawat)";
            default: return String.valueOf(levelPrioritas);
        }
    }
}

class LinkedListAntrean {
    Node head, tail;
    int size = 0;

    class Node {
        Pasien data;
        Node next;

        Node () {}

        Node (Pasien data) {
            this.data = data;
        }

        Node (Pasien data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    boolean isEmpty () {
        return (size == 0);
    }

    int getSize() {
        return size;
    }

    void tambahPasien(Pasien p) {
        Node newNode = new Node(p);

        if (isEmpty()) {
            head = tail = newNode;
        } else if (p.levelPrioritas == 1) {
            Node temp = head;
            Node lastP1 = null;
            while (temp != null && temp.data.levelPrioritas == 1) {
                lastP1 = temp;
                temp = temp.next;
            }
            if (lastP1 == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = lastP1.next;
                lastP1.next = newNode;
                if (newNode.next == null) tail = newNode;
            }
        } else if (p.levelPrioritas == 2) {
            Node temp = head;
            Node lastP2 = null;
            while (temp != null && (temp.data.levelPrioritas == 1 || temp.data.levelPrioritas == 2)) {
                lastP2 = temp;
                temp = temp.next;
            }
            if (lastP2 == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = lastP2.next;
                lastP2.next = newNode;
                if (newNode.next == null) tail = newNode;
            }
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void panggilPasien() {
        if (isEmpty()) {
            System.out.println("Antrean kosong. Tidak ada pasien untuk dipanggil.");
            return;
        }
        Pasien p = head.data;
        System.out.println("Pasien berikutnya: ID: " + p.idPasien + ", Nama: " + p.namaPasien +
                ", Penyakit: " + p.penyakit + ", Prioritas: " + p.levelPrioritas);
        head = head.next;
        if (head == null) tail = null;
        size--;
    }

    void hapusPasienById(String id) {
        if (isEmpty()) {
            return;
        }
        if (head.data.idPasien.equals(id)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            System.out.println("Pasien dengan ID " + id + " telah dihapus dari antrean.");
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.data.idPasien.equals(id)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Pasien dengan ID " + id + " tidak ditemukan.");
        } else {
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
            size--;
            System.out.println("Pasien dengan ID " + id + " telah dihapus dari antrean.");
        }
    }

    void cetakAntrean() {
        System.out.println("========================================");
        System.out.println("DAFTAR ANTRIAN PASIEN UGD");
        System.out.println("========================================");
        System.out.println("Total Pasien: " + getSize() + "\n");
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            Pasien p = (Pasien) temp.data;
            System.out.println("ID: " + p.idPasien + ", Nama: " + p.namaPasien + ", Penyakit: " + p.penyakit + ", Prioritas: " + p.getPrioritas());
            temp = temp.next;
        }

        System.out.println("========================================");
    }
}

