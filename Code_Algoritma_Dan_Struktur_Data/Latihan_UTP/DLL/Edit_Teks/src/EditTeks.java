import java.util.Scanner;

public class EditTeks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLL d = new DLL();

        System.out.println("=== Edit Teks ===");
        System.out.println("1. Tambah Versi");
        System.out.println("2. Undo");
        System.out.println("3. Redo");
        System.out.println("0. Keluar");

        boolean flag = true;

        while (flag){
            System.out.print("\nPilih menu: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1: {
                    break;
                }

                case 2: {
                    break;
                }

                case 3: {
                    break;
                }

                case 0: {
                    System.out.println("Keluar dari program...");
                    System.out.println("");
                    flag = false;
                    break;
                }

                default: {

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


    }
}