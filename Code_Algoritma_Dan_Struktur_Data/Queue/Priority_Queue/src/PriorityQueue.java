public class PriorityQueue {
    private class Item {
        String nama;
        int prioritas;

        Item(String nama, int prioritas) {
            this.nama = nama;
            this.prioritas = prioritas;
        }

        @Override
        public String toString() {
            return "[" + nama + ", prioritas: " + prioritas + "]";
        }
    }

    private Item[] queue;
    private int size;
    private int maxSize;

    public PriorityQueue(int maxSize){
        this.maxSize = maxSize;
        this.queue = new Item[maxSize];
        this.size = 0;
    }

    public void enqueue(String nama, int prioritas){
        if (size == maxSize) {
            System.err.println("Antrian penuh!");
            return;
        }

        Item newItem = new Item(nama, prioritas);
        int i;
        
        for (i = size - 1; i >= 0; i--){
            if (queue[i].prioritas > prioritas){
                queue[i + 1] = queue[i];
            } else {
                break;
            }
        }
        
        queue[i + 1] = newItem;
        size++;
        System.out.println((nama + " ditambahkan dengan prioritas " + prioritas));
    }
    
    public void dequeue() {
        if (size == 0){
            System.err.println("Antrian kosong!");
            return;
        }

        System.out.println("Mengeluarkan: " + queue[0].nama);

        for (int i = 0; i < size - 1; i++){
            queue[i] = queue[i + 1];
        }

        queue[size - 1] = null;
        size--;
    }

    public void peek(){
        if (size == 0){
            System.err.println("Antrian kosong!");
        } else {
            System.out.println("Prioritas tertinggi: " + queue[0]);
        }
    }

    public void display() {
        if (size == 0){
            System.err.println("Antrian kosong!");
            return;
        }

        System.out.println("Isi antrian:");
        for (int i = 0; i < size; i++){
            System.out.println(" - " + queue[i]);
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);

        pq.enqueue("Pasien A", 3);
        pq.enqueue("Pasien B", 1);
        pq.enqueue("Pasien C", 2);

        pq.display();
        pq.peek();
    }
}