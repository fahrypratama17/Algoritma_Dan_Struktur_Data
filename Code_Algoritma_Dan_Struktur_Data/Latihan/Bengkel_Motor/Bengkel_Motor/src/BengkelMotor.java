import java.util.Scanner;

public class BengkelMotor {
    public static void main(String[] args) {
        String nama, jenis;
        int harga, choice;
        boolean flag = true;

        Scanner input = new Scanner(System.in);
        SLL sll = new SLL();

        System.out.println("=== SISTEM ANTRIAN BENGKEL MOTOR ===");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Hapus Antrian");
        System.out.println("3. Cari Pelanggan");
        System.out.println("4. Tampilkan Semua Antrian");
        System.out.println("5. Hitung Total Pendapatan");
        System.out.println("6. Keluar");

        while (flag) {
            System.out.print("Pilih menu: ");
            choice = input.nextInt(); input.nextLine();
            switch (choice){
                case 1: {
                    System.out.print("\nMasukkan Nama: "); nama = input.nextLine();
                    System.out.print("Masukkan Jenis: "); jenis = input.nextLine();
                    System.out.print("Masukkan Harga: "); harga = input.nextInt();
                    Motor m = new Motor(nama, jenis, harga);
                    sll.tambahAntrian(m); input.nextLine();
                    System.out.println("Pelanggan atas nama " +  nama + " berhasil ditambahkan ke antrian\n");
                    break;
                }

                case 2: {
                    System.out.println("Pelanggan atas nama " + sll.head.data.namaPelanggan + " telah selesai");
                    sll.hapusAntrian();
                    break;
                }

                case 3: {
                    System.out.print("Masukkan nama pelanggan yang dicari: " );
                    nama = input.nextLine();
                    sll.cariPelanggan(nama);
                    break;
                }

                case 4: {
                    sll.tampilkanAntrian();
                    break;
                }

                case 5: {
                    System.out.println("Total pendapatan dari antrian saat ini: " + sll.hitungPendapatan());
                    break;
                }

                default: {
                    System.out.println("\nTerima kasih! Program selesai.");
                    flag = false;
                }
            }
        }
    }
}

class Motor {
    String namaPelanggan, jenisServis;
    int biayaServis;

    Motor(String namaPelanggan, String jenisPelanggan, int biayaServis){
        this.namaPelanggan = namaPelanggan;
        this.jenisServis = jenisPelanggan;
        this.biayaServis = biayaServis;
    }
}

class Node {
    Motor data;
    Node next;

    Node (){}

    Node(Motor data){
        this.data = data;
    }

    Node(Motor data, Node next){
        this.data = data;
        this.next = next;
    }
}

class SLL {
    Node head, tail;
    int size = 0;

    public boolean isEmpty(){
        return (size == 0);
    }

    public int getSize(){
        return size;
    }

    public void tambahAntrian(Motor motor){
        Node m = new Node(motor);

        if (isEmpty()){
            head = tail = m;
            size++;
            return;
        }

        if (size == 1){
            head.next = m;
            tail = m;
            size++;
            return;
        }

        Node temp = head;
        while (tail.next != null){
            if (temp.data.equals(tail.data)){
                tail.next = m;
                tail = m;
            }
            temp = temp.next;
        }
        size++;
    }

    public void hapusAntrian(){
        if (isEmpty()){
            System.err.println("Bengkel motor kosong nih!");
            return;
        }

        if (head.data.equals(tail.data)){
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    public void cariPelanggan(String nama){
        Node temp = head;
        while (!temp.equals(null)) {
            if (temp.data.namaPelanggan.equals(nama)) {
                System.out.println("Pelanggan ditemukan: " + temp.data.namaPelanggan + " - " + temp.data.jenisServis + " - Rp" + temp.data.biayaServis);
                return;
            }
            temp = temp.next;
        }
    }

    public int hitungPendapatan(){
        int total = 0;
        Node temp = head;
        while (!temp.equals(null)){
            total += temp.data.biayaServis;
            temp = temp.next;
        }
        return total;
    }

    public void tampilkanAntrian(){
        Node temp = head;
        int i = 0;

        if (isEmpty()){
            System.err.println("Bengkel motor kosong nih!");
            return;
        }

        System.out.println("\n=== Daftar Antrian ===");
        while (temp != null){
            i++;
            System.out.println(i + ". " + temp.data.namaPelanggan + " - " + temp.data.jenisServis + " - Rp" + temp.data.biayaServis);
            temp = temp.next;
        }
    }
}