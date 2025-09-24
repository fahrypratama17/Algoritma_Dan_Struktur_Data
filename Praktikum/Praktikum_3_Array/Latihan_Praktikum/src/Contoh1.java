import java.util.Scanner;

public class Contoh1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int baris = input.nextInt(), kolom = input.nextInt();

        int[][] array = new int[baris][kolom];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array[0].length - 1 ; j >= 0 ;  j--) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = array.length - 1; i >= 0; i--) {
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}