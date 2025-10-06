import java.util.Scanner;

public class EditTeks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLL d = new DLL();

        System.out.println("=== Edit Teks ===");
        System.out.println("1. Tambah Versi");
        System.out.println("2. Undo");
        System.out.println("3. Redo");
        System.out.println("4. Tampilkan Versi Sekarang");
        System.out.println("0. Keluar");

        boolean flag = true;

        while (flag){
            System.out.print("\nPilih menu: ");
            int choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Masukkan teks: ");
                    String teks = input.nextLine();

                    Teks t = new Teks(teks);
                    d.tambahVersi(t);
                    break;
                }

                case 2: {
                    d.undo();
                    break;
                }

                case 3: {
                    d.redo();
                    break;
                }

                case 4: {
                    d.tampiilkanVersiSekarang();
                    break;
                }

                case 0: {
                    System.out.println("Keluar dari program...");
                    System.out.println("Terima kasih dan Selamat Tinggal!!!");
                    flag = false;
                    break;
                }

                default: {
                    System.out.println("Pilihan hanya dari 0-3");
                    flag = false;
                }
            }
        }
    }
}

class Teks {
    String teks;

    Teks (String teks){
        this.teks = teks;
    }
}

class Node {
    Teks data;
    Node next, prev;

    Node (Teks data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    Node head, tail, current;
    int size;

    boolean isEmpty() {
        return (size == 0);
    }

    int getSize(){
        return size;
    }

    void tambahVersi(Teks data){
        Node versiBaru = new Node(data);

        if (isEmpty()){
            head = tail = current = versiBaru;
            size++;
        } else {
            tail.next = versiBaru;
            versiBaru.prev = tail;
            tail = current = versiBaru;
            size++;
        }
    }

    void undo() {
        if (isEmpty()) {
            System.err.println("Teks kosong!!!");
            return;
        }

        if (current.prev == null){
            System.err.println(current.data.teks + " sudah paling belakang!!!");
        } else {
            current = current.prev;
        }
    }

    void redo() {
        if (isEmpty()) {
            System.err.println("Teks kosong!!!");
            return;
        }

        if (current.next == null){
            System.err.println(current.data.teks + " sudah paling belakang!!!");
        } else {
            current = current.next;
        }
    }

    void tampiilkanVersiSekarang() {
        if (isEmpty()) {
            System.err.println("Teks kosong!!!");
            return;
        }

        System.out.println("Versi sekarang: " + current.data.teks);
    }
}