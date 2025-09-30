import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        SchedulerRoundRobin CDLL = new SchedulerRoundRobin();

        int jmlP = input.nextInt();
        int qt = input.nextInt();
        CDLL.setQuantumTime(qt);

        for (int i = 0; i < jmlP; i++){
            Proses p = new Proses(input.next(), input.next(), input.nextInt());
            CDLL.tambahProses(p);
        }
        CDLL.cetakStatusProses();
    }
}

class Proses {
    String idProses;
    String namaProses;
    int waktuEksekusiProses;
    Proses next, prev;

    Proses (String idProses, String namaProses, int waktuEksekusiProses){
        this.idProses = idProses;
        this.namaProses = namaProses;
        this.waktuEksekusiProses = waktuEksekusiProses;
    }

    Proses() {}

    Proses (String idProses, String namaProses, int waktuEksekusiProses, Proses next, Proses prev) {
        this.idProses = idProses;
        this.namaProses = namaProses;
        this.waktuEksekusiProses = waktuEksekusiProses;
        this.next = next;
        this.prev = prev;
    }
}

class SchedulerRoundRobin {
    Proses head, tail, current;
    int quantumTime = 0, size = 0, siklus = 0;

    void setQuantumTime(int qt) {
        this.quantumTime = qt;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean apakahSelesai() {
        Proses temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.waktuEksekusiProses > 0) return false;
            temp = temp.next;
        }
        return true;
    }

    void tambahProses(Proses p){
        if (isEmpty()){
            head = tail = p;
            head.prev = head;
            head.next = head;
        } else {
            p.next = head;
            p.prev = tail;
            tail.next = p;
            head.prev = p;
            tail = p;
        }
        size++;
    }

    void jalankanSiklus(){
        if (current == null) return;

        current.waktuEksekusiProses -= quantumTime;

        if (current.waktuEksekusiProses <= 0){
            current.waktuEksekusiProses = 0;
            System.out.println("Proses " + current.idProses + " (" + current.namaProses + ") telah selesai.");
        }

        current = current.next;
        head = current;
        siklus++;
    }

    void cetakStatusProses() {
        System.out.println("Kondisi Awal:");
        Proses temp = head;
        for (int i = 0; i < size; i++){
            if (temp.equals(head)) {
                System.out.println("-> Proses " + temp.idProses + " (" + temp.namaProses + "), Sisa Waktu: " + temp.waktuEksekusiProses + " (CURRENT)");
            } else {
                System.out.println("-> Proses " + temp.idProses + " (" + temp.namaProses + "), Sisa Waktu: " + temp.waktuEksekusiProses);
            }
            temp = temp.next;
        }

        current = head;

        while (!apakahSelesai()){
            System.out.println("\n--- Siklus ke-" + (siklus+1) + " ---");
            jalankanSiklus();

            if (!apakahSelesai()) {
                Proses curr = head;
                for (int i = 0; i < size; i++) {
                    if (curr.waktuEksekusiProses > 0) {
                        if (curr == current){
                            System.out.println("-> Proses " + curr.idProses + " (" + curr.namaProses + "), Sisa Waktu: " + curr.waktuEksekusiProses + " (CURRENT)");
                        } else {
                            System.out.println("-> Proses " + curr.idProses + " (" + curr.namaProses + "), Sisa Waktu: " + curr.waktuEksekusiProses);
                        }
                    }
                    curr = curr.next;
                }
            }
        }
        System.out.println("Tidak ada proses tersisa.");
    }
}

