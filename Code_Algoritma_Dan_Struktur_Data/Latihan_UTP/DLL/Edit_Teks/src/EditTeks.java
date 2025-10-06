import java.util.Scanner;

public class EditTeks {
    public static void main(String[] args) {

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
}

class DLL {
    Node head, tail, current;
    int size;


}