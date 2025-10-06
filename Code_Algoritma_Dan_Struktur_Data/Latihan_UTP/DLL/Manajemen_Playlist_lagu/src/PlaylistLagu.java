import java.util.Scanner;

public class PlaylistLagu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLL d = new DLL();

        System.out.println("=== Manajemen Playlist Lagu ===");
        System.out.println("1. Tambah Lagu");
        System.out.println("2. Hapus Lagu");
        System.out.println("3. Tampilkan Dari Awal");
        System.out.println("4. Tampilkan Dari Akhir");
        System.out.println("0. Keluar");

        boolean flag = true;

        while (flag){
            System.out.print("\nPilih menu: ");
            int choice = input.nextInt(); input.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("\nMasukkan judul lagu: ");
                    String judul = input.nextLine();
                    Lagu l = new Lagu(judul);

                    d.tambahLagu(l);
                    break;
                }

                case 2: {
                    System.out.print("Masukkan judul yang ingin dihapus: ");
                    String judul = input.nextLine();

                    d.hapusLagu(judul);
                    break;
                }

                case 3: {
                    d.tampilDariDepan();
                    break;
                }

                case 4: {
                    d.tampilDariBelakang();
                    break;
                }

                case 0: {
                    System.out.println("Keluar dari program...");
                    System.out.println("Terima kasih dan Selamat Tinggal");
                    flag = false;
                    break;
                }

                default: {
                    System.err.println("Pilihan dari 0-4");
                    flag = false;
                }
            }
        }
    }
}

class Lagu {
    String judul;

    Lagu (String judul){
        this.judul = judul;
    }
}

class Node {
    Lagu data;
    Node next, prev;

    Node (Lagu data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    Node head, tail;
    int size;

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    void tambahLagu(Lagu data){
        Node laguBaru = new Node(data);

        if (isEmpty()){
            head = tail = laguBaru;
        } else {
            tail.next = laguBaru;
            laguBaru.prev = tail;
            tail = laguBaru;
        }
        size++;
    }

    void hapusLagu(String judul){
        if (isEmpty()){
            System.err.println("Maaf, playlist lagu kosong!");
            return;
        }

        if (head.data.judul.equals(judul)){
            head = head.next;
            head.prev = null;
        } else if (tail.data.judul.equals(judul)){
            tail = tail.prev;
            tail.next = null;
        }

        Node temp = head;
        while (temp != null){
            if (temp.data.judul.equals(judul)){
                temp.prev.next = temp.next;
                if (temp.next != null){
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
            size--;
        }
    }

    void tampilDariDepan(){
        if (isEmpty()){
            System.out.println("Maaf, playlist kosong!");
        }

        Node temp = head;
        int i = 0;

        System.out.println("\nPlaylist: ");
        while (temp != null){
            i++;
            System.out.println(i + ". " + temp.data.judul);
            temp = temp.next;
        }
    }

    void tampilDariBelakang(){
        if (isEmpty()){
            System.out.println("Maaf, playlist kosong!");
        }

        Node temp = tail;
        int i = size + 1;

        System.out.println("\nPlaylist: ");
        while (temp != null){
            i--;
            System.out.println(i + ". " + temp.data.judul);
            temp = temp.prev;
        }
    }
}