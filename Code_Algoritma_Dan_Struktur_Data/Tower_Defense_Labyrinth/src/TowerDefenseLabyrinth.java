// ---------------------------------------------
// Tugas 1 - Tower Defense Labyrinth (OPTIMIZED)
// ---------------------------------------------

import java.util.Scanner;

public class TowerDefenseLabyrinth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Tower blueTowerData = TowerInput(input);
        Tower redTowerData = TowerInput(input);

        input.close();

        int blueTowerFastest = TowerData(blueTowerData, "BLUE");
        int redTowerFastest = TowerData(redTowerData, "RED");

        System.out.println();

        if (blueTowerFastest < redTowerFastest) {
            System.out.println("BLUE TOWER TEAM IS WINNER");
            System.out.print(blueTowerFastest + " steps vs " + redTowerFastest + " steps");
        } else if (redTowerFastest < blueTowerFastest) {
            System.out.println("RED TOWER TEAM IS WINNER");
            System.out.print(redTowerFastest + " steps vs " + blueTowerFastest + " steps");
        } else {
            System.out.print("BOTH TEAMS ARE TIED, NO WINNER");
        }
    }

    static Tower TowerInput(Scanner input) {
        int sizeLabirin = Integer.parseInt(input.nextLine());
        String koorBisaDilalui = input.nextLine();
        int jmlPeserta = Integer.parseInt(input.nextLine());

        String[] dataPeserta = new String[jmlPeserta];
        for (int i = 0; i < jmlPeserta; i++) {
            dataPeserta[i] = input.nextLine().trim();
        }
        return new Tower(sizeLabirin, koorBisaDilalui, jmlPeserta, dataPeserta);
    }

    static int TowerData(Tower data, String team) {
        int sizeLabirin = data.sizeLabirin;
        Labirin lab = new Labirin(sizeLabirin);

        String[] koordinatBD = data.koorBisaDilalui.split(" ");
        int[][] arrayBD = new int[koordinatBD.length][2];

        int count = 0;
        for (String s : koordinatBD) {
            String[] xy = s.split(",");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            arrayBD[count][0] = x;
            arrayBD[count][1] = y;
            count++;
        }

        Koordinat start = new Koordinat(arrayBD[0][0], arrayBD[0][1]);
        Koordinat finish = new Koordinat(arrayBD[count - 1][0], arrayBD[count - 1][1]);

        lab.setBisaDilalui(arrayBD, count);
        lab.setStartFinish(start, finish);

        PriorityQueue pq = new PriorityQueue();

        for (int i = 0; i < data.jmlPeserta; i++) {
            String[] input = data.dataPeserta[i].split(" ");
            String namaPeserta = input[0];

            String[] direction = new String[input.length - 1];
            System.arraycopy(input, 1, direction, 0, input.length - 1);

            Peserta peserta = new Peserta(namaPeserta, direction, sizeLabirin);
            boolean[][] sudahDilalui = new boolean[sizeLabirin][sizeLabirin];

            peserta.steps = 0;
            solveMaze(peserta, sudahDilalui, start.x, start.y, finish.x, finish.y, lab);

            pq.enqueue(peserta);
        }

        if (team.equals("BLUE")){
            System.out.println(team + " TEAM ENTERED RED TOWER");
        } else {
            System.out.println("\n" + team + " TEAM ENTERED BLUE TOWER");
        }

        Queue printQueue = new Queue();
        Peserta fastestPeserta = null;

        while (!pq.isEmpty()) {
            Peserta p = pq.dequeue();
            printQueue.enqueue(p);

            if (fastestPeserta == null && p.steps > 0) {
                fastestPeserta = p;
            }

            System.out.println(p.nama);
            printLabirin(p, lab);
        }

        System.out.println();

        if (fastestPeserta != null) {
            System.out.print("FASTEST " + fastestPeserta.nama + " " + fastestPeserta.steps + " steps");

            printQueue.dequeue();
            while (!printQueue.isEmpty()) {
                Peserta p = printQueue.dequeue();
                if (p.steps > 0) {
                    System.out.print("\n" + p.nama + " " + p.steps + " steps");
                }
            }
        } else {
            System.out.print("FASTEST - 0 steps");
        }

        System.out.println();

        return (fastestPeserta != null) ? fastestPeserta.steps : Integer.MAX_VALUE;
    }

    static boolean solveMaze(Peserta p, boolean[][] sudahDilalui, int sx, int sy, int fx, int fy, Labirin lab) {
        if (sx < 0 || sx >= lab.size || sy < 0 || sy >= lab.size || !lab.bisaDilalui[sx][sy] || sudahDilalui[sx][sy]) {
            return false;
        }

        p.steps++;
        sudahDilalui[sx][sx] = true;
        p.pathNumbers[sx][sx] = p.steps;

        if (sx == fx && sy == fy) {
            return true;
        }

        for (int i = 0; i < p.direction.length; i++) {
            String dir = p.direction[i];
            int nextX = sx;
            int nextY = sy;

            switch (dir) {
                case "UP" -> nextY++;
                case "DOWN" -> nextY--;
                case "RIGHT" -> nextX++;
                case "LEFT" -> nextX--;
            }

            if (solveMaze(p, sudahDilalui, nextX, nextY, fx, fy, lab)) {
                return true;
            }
        }
        return false;
    }

    static void printLabirin(Peserta p, Labirin lab) {
        for (int i = lab.size - 1; i >= 0; i--) {
            for (int j = 0; j < lab.size; j++) {
                if (p.pathNumbers[i][j] > 0) {
                    System.out.printf("[%02d]", p.pathNumbers[i][j]);
                } else if (lab.bisaDilalui[i][j]) {
                    System.out.print("[OO]");
                } else {
                    System.out.print("[XX]");
                }
            }
            System.out.println();
        }
    }
}

class Tower {
    int sizeLabirin;
    String koorBisaDilalui;
    int jmlPeserta;
    String[] dataPeserta;

    public Tower(int sizeLabirin, String koorBisaDilalui, int jmlPeserta, String[] dataPeserta) {
        this.sizeLabirin = sizeLabirin;
        this.koorBisaDilalui = koorBisaDilalui;
        this.jmlPeserta = jmlPeserta;
        this.dataPeserta = dataPeserta;
    }

}

class Koordinat {
    int x, y;

    Koordinat(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Labirin {
    int size;
    boolean[][] bisaDilalui;
    Koordinat start, finish;

    Labirin(int size) {
        this.size = size;
        this.bisaDilalui = new boolean[size][size];
    }

    void setBisaDilalui(int[][] koordinatJalur, int count) {
        for (int i = 0; i < count; i++) {
            int x = koordinatJalur[i][0];
            int y = koordinatJalur[i][1];
            if (x >= 0 && x < size && y >= 0 && y < size) {
                bisaDilalui[y][x] = true;
            }
        }
    }

    void setStartFinish(Koordinat start, Koordinat finish) {
        this.start = start;
        this.finish = finish;
    }
}

class Peserta {
    String nama;
    String[] direction;
    int steps;
    int[][] pathNumbers;

    Peserta(String nama, String[] direction, int size) {
        this.nama = nama;
        this.direction = direction;
        this.steps = 0;
        this.pathNumbers = new int[size][size];
    }
}

class Node {
    Peserta data;
    Node next;

    Node(Peserta data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    Queue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(Peserta data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    Peserta dequeue() {
        if (isEmpty()) {
            return null;
        }

        Peserta temp = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return temp;
    }
}

class PriorityQueue {
    Node front;

    boolean isEmpty() {
        return front == null;
    }

    PriorityQueue() {
        this.front = null;
    }

    void enqueue(Peserta peserta) {
        Node newNode = new Node(peserta);

        if (front == null || front.data.steps > peserta.steps || (front.data.steps == peserta.steps && front.data.nama.compareTo(peserta.nama) > 0)) {
            newNode.next = front;
            front = newNode;
        } else {
            Node current = front;
            while (current.next != null && (current.next.data.steps < peserta.steps || (current.next.data.steps == peserta.steps && current.next.data.nama.compareTo(peserta.nama) < 0))) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    Peserta dequeue() {
        if (isEmpty()) {
            return null;
        }
        Peserta peserta = front.data;
        front = front.next;
        return peserta;
    }
}