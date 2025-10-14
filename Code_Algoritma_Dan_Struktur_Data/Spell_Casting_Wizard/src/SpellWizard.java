import java.util.Scanner;

public class SpellWizard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input boleh diubah sesuai preferensi, asalkan format sesuai deskripsi soal
        //boleh linked list atau array

        StackSpell stack = new StackSpell();

        while (true) {
            String command = sc.next();

            if (command.equals("LEARN")) {
                String spell = sc.next();
                stack.learn(spell);
            }

            else if (command.equals("FORGET")) {
                stack.forget();
            }

            else if (command.equals("CAST")) {
                stack.cast();
            }

            else if (command.equals("SHOW")) {
                stack.show();
            }

            else if (command.equals("COUNT")) {
                stack.count();
            }

            else if (command.equals("CLEAR")) {
                stack.clear();
            }

            else if (command.equals("STOP")) {
                break;
            }
        }
    }
}

// Node dan Stack boleh diubah sesuai preferensi, asalkan format sesuai deskripsi soal

// Node class untuk menyimpan data mantra
class Node {
    String spell;
    Node next;

    Node(String spell) {
        this.spell = spell;
        this.next = null;
    }
}

// Stack berbasis Linked List
class StackSpell {
    private Node top;   // Menunjuk ke mantra paling atas
    private int size;   // Menyimpan jumlah mantra

    boolean isEmpty() {
        return (top == null);
    }

    boolean sudahDipelajari(String spell){
        Node current = top;
        while (current != null){
            if (current.spell.equals(spell)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void learn(String spell) {
        if (sudahDipelajari(spell)){
            System.out.println(spell + " sudah dipelajari sebelumnya");
        } else {
            Node spellBaru = new Node(spell);
            spellBaru.next = top;
            top = spellBaru;
            size++;
            System.out.println(spell + " dipelajari");
        }
    }

    void forget(){
        if (isEmpty()){
            System.out.println("Tidak ada mantra yang bisa dilupakan");
        } else{
            String lupainMantra = top.spell;
            top = top.next;
            size--;
            System.out.println(lupainMantra + " dihapus");
        }
    }

    void cast() {
        if (isEmpty()){
            System.out.println("Tidak ada mantra untuk digunakan");
        } else {
            System.out.println("Menggunakan mantra " + top.spell);
        }
    }

    void show() {
        if (isEmpty()) {
            System.out.println("Buku mantra kosong");
            return;
        }

        String[] arrSpell = new String[size];
        Node current = top;
        int index = size - 1;

        while (current != null) {
            arrSpell[index] = current.spell;
            current = current.next;
            index--;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(arrSpell[i]);
        }
    }


    void count(){
        System.out.println("Jumlah mantra: " + size);
    }

    void clear() {
        top = null;
        size = 0;
        System.out.println("Semua mantra dihapus");
    }
}