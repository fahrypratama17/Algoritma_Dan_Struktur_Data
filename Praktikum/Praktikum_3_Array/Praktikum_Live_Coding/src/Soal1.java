import java.util.Scanner;
import java.util.Arrays;

public class Soal1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int panjang = input.nextInt();
        int[] array = new int[panjang];

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        Arrays.sort(array);

        float avg = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            avg += (float) array[i];
        }

        System.out.println();
        avg /= (float) panjang;
        System.out.printf("%.2f", avg);

        System.out.println();
        System.out.print(array[array.length - 1] + " ");
        System.out.print(array[0]);

        System.out.println();
        int Ganjil = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
                Ganjil++;
            }
        }
        if (Ganjil == 0) {
            System.out.print("None");
        }

        System.out.println();
        int bilPrima = 0;
        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            if (n > 1) {
                boolean prima = true;
                if (n % 2 == 0 && n != 2) {
                    prima = false;
                } else {
                    for (int j = 3; j * j <= n; j += 2) {
                        if (n % j == 0) {
                            prima = false;
                            break;
                        }
                    }
                }
                if (prima) {
                    System.out.print(n + " ");
                    bilPrima++;
                }
            }
        }
        if (bilPrima == 0) {
            System.out.print("None");
        }
    }
}