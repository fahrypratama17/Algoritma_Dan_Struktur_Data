import java.util.*;

public class Main {
    public static void main(String[] args) {
        PercobaanSatu Array1 = new PercobaanSatu();
        PercobaanDua Array2 = new PercobaanDua();
        PercobaanTiga Array3 = new PercobaanTiga();
        PercobaanEmpat Array4 = new PercobaanEmpat();
        PercobaanLima Array5 = new PercobaanLima();

        Array1.ArrayPercobaanSatu();
        System.out.println();
        Array2.ArrayPercobaanDua();
        System.out.println();
        Array3.ArrayPercobaanTiga();
        System.out.println();
        Array4.ArrayPercobaanEmpat();
        System.out.println();
        Array5.ArrayPercobaanLima();

    }
}

class PercobaanSatu {
    void ArrayPercobaanSatu() {
        int[] anArray;
        anArray = new int[10];

        anArray[0] = 10;
        anArray[1] = 20;
        anArray[2] = 30;
        anArray[3] = 40;
        anArray[4] = 50;
        anArray[5] = 60;
        anArray[6] = 70;
        anArray[7] = 80;
        anArray[8] = 90;
        anArray[9] = 100;

        System.out.println("\nMembuat array, menyimpan array, dan mengakses array 1 dimensi:");
        int i = 0;
        while ( i < anArray.length) {
            System.out.println("Index Element " + i + " = " + anArray[i]);
            i++;
        }
    }
}

class PercobaanDua {
    void ArrayPercobaanDua() {
        System.out.println("Mengurutkan data dan menyisipkan data pada array:");
        int cobaArraySort[] = {2, 5, -2, 6, -3, 8,0, -7, -9, 4};
        Arrays.sort(cobaArraySort);
        printArray("Sorted array", cobaArraySort);

        int index = Arrays.binarySearch(cobaArraySort, 1);
        System.out.println("Didn't find 1 @ " + index);
        int newIndex = -index - 1;
        cobaArraySort = insertElement(cobaArraySort, 1, newIndex);
        printArray("With 1 added ", cobaArraySort);
    }

    private static void printArray(String message, int arraySorted[]) {
        System.out.println(message + ": [length: " + arraySorted.length + "]");

        for (int i = 0; i < arraySorted.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arraySorted[i]);
        }
        System.out.println();
    }

    private static int[] insertElement(int original[], int element, int index) {
        int length = original.length;
        int destination[] = new int[length + 1];
        System.arraycopy(original, 0 , destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length - index);
        return destination;
    }
}

class PercobaanTiga {
    void ArrayPercobaanTiga() {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        int[] array3 = {1, 2, 3, 4};

        System.out.println("Membandingkan dua buah array:");
        System.out.println("Variabel array1 = array2 ? " + Arrays.equals(array1, array2));
        System.out.println("Variabel array1 = array3 ? " + Arrays.equals(array1, array3));
        System.out.println("Variabel array2 = array3 ? " + Arrays.equals(array2, array3));
    }
}

class PercobaanEmpat {
    void ArrayPercobaanEmpat() {
        int[][] arrayDuaDimensi = new int[10][5];

        System.out.println("Array Dua Dimensi:");
        for (int i = 0; i < arrayDuaDimensi.length; i++) {
            for (int j = 0; j < arrayDuaDimensi[i].length; j++) {
                arrayDuaDimensi[i][j] = i;
                System.out.print(" " + arrayDuaDimensi[i][j]);
            }
            System.out.println();
        }
    }
}

class PercobaanLima {
    void ArrayPercobaanLima() {
        String[][] data = new String[4][5];
        System.out.println("Dimensi 1: " + data.length);
        System.out.println("Dimensi 2: " + data[0].length);
    }
}