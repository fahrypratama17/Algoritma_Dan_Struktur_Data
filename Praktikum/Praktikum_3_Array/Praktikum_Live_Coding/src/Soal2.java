import java.util.Scanner;
import java.util.Arrays;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt(); int n = input.nextInt();
        int[][] array2 = new int[m][n];

        int[] array1 = new int[m*n];
        int temp = 0;
        int k = 0;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                array2[i][j] = input.nextInt();
                temp = array2[i][j];
                array1[k++] = temp;
            }
        }

        int kaliUlang = input.nextInt();

        for (int i = 0; i < kaliUlang; i++) {
            int index1 = input.nextInt();
            int index2 = input.nextInt();

            int tempLagi = array1[index1];

            if (index1 < index2) {
                for (int j = index1; j < index2; j++) {
                    array1[j] = array1[j + 1];
                }
                array1[index2] = tempLagi;
            } else if (index1 > index2) {
                for (int j = index1; j > index2; j--) {
                    array1[j] = array1[j - 1];
                }
                array1[index2] = tempLagi;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array1[i*n + j] + " ");
            }
            System.out.println();
        }
    }
}
