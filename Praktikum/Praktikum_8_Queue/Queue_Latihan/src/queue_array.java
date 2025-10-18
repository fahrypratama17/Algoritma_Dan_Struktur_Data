import java.util.Scanner;

public class queue_array {
    Scanner masuk = new Scanner(System.in);

    int choice, i;
    char item;
    final int MAX_SIZE = 10;
    char arr_queue[] = new char[MAX_SIZE];
    int keluar = 0;
    int rear = 0;

    public void enqueue(char item) {
        if (rear == MAX_SIZE) {
            System.out.print("\n# Queue Penuh");
        } else {
            for (i = rear; i > 0; i--) {
                arr_queue[i] = arr_queue[i - 1];
            }
            arr_queue[0] = item;
            rear++;
            System.out.print("\n# Enqueue: " + item + " dimasukkan di index 0");
        }
    }

    public void dequeue() {
        if (rear == 0)
            System.out.print("\n## Queue kosong");
        else {
            System.out.print("\n## Dequeue Value: " + arr_queue[rear - 1]);
            rear--;
        }
    }

    public void printAll() {
        System.out.print("\n## Queue Size : " + rear);
        for (i = 0; i < rear; i++)
            System.out.print("\n## No Urut/index : " + i + ", Value :" + arr_queue[i]);
    }

    public void menu() {
        System.out.print("\nMasukkan operasi yang akan dilakukan (1:enqueue, 2:dequeue, 3:print) : ");
        choice = masuk.nextInt();
        masuk.nextLine();
        switch (choice) {
            case 1: {
                System.out.print("\nMasukkan huruf yang akan di-enqueue : ");
                item = masuk.nextLine().charAt(0);
                enqueue(item);
            }
            break;
            case 2:
                dequeue();
                break;
            case 3:
                printAll();
                break;
            default:
                System.out.print("\n1:enqueue, 2:dequeue, 3:print\n");
                keluar = 1;
                break;
        }
    }

    public static void main(String[] args) {
        queue_array qa = new queue_array();
        do {
            qa.menu();
        } while (qa.keluar == 0);
    }
}