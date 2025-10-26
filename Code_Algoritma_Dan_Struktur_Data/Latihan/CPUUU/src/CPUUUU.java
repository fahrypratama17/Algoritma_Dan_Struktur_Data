import java.util.Scanner;

public class CPUUUU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueProcess q = new QueueProcess();

        while (true) {
            String operasi = sc.next();

            switch (operasi) {
                case "ARRIVE":
                    String id = sc.next();
                    int burstTime = sc.nextInt();
                    Process p = new Process(id, burstTime);

                    q.enqueue(p);
                    System.out.println("Proses " + id + " tiba dengan waktu eksekusi " + burstTime);
                    break;

                case "RUN":
                    q.dequeue();
                    break;

                case "STATUS":
                    q.print();
                    break;

                case "STOP":
                    return;
            }
        }
    }
}

// ===============================
// Class Process
// ===============================
// Menyimpan data proses: id dan burst time.
// Boleh dikembangkan sesuai kebutuhan.
class Process {
    String id;
    int burstTime;

    Process(String id, int burstTime){
        this.id = id;
        this.burstTime = burstTime;
    }
}

class Node {
    Process data;
    Node next;

    Node(Process data){
        this.data = data;
        this.next = null;
    }
}

// ===============================
// Class QueueProcess
// ===============================
// Implementasi ADT Queue (opsional).
// Boleh menggunakan Queue (Linked List) atau Array.
class QueueProcess {
    Node front, rear;
    int size;

    QueueProcess(){
        front = rear = null;
        size = 0;
    }

    boolean isEmpty(){
        return (front == null);
    }

    void enqueue(Process data){
        Node proses = new Node(data);

        if (rear == null){
            front = rear = proses;
        } else {
            rear.next = proses;
            rear = proses;
        }

        size++;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Tidak ada proses yang siap dijalankan");
            return;
        }

        Node temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;

        temp.data.burstTime--;

        if (temp.data.burstTime == 0) {
            System.out.println("Proses " + temp.data.id + " dijalankan (sisa " + temp.data.burstTime + ")");
            System.out.println("Proses " + temp.data.id + " selesai");
        } else {
            System.out.println("Proses " + temp.data.id + " dijalankan (sisa " + temp.data.burstTime + ")");
            enqueue(temp.data);
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Tidak ada proses dalam antrian");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data.id + " " + temp.data.burstTime);
            temp = temp.next;
        }
    }
}