import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Contoh3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int titik = input.nextInt();

        if (titik == 1) {
            System.out.println("Minimal harus ada 2 titik!");
            return;
        }

        double[][] array = new double[titik][2];
        double[] array2 = new double[titik];
        double titikSekarang = 0, temp = 0, x, y;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++){
                array[i][j] = input.nextDouble();
            }
        }

        for (int i = 0; i < array.length; i++) {
            x = array[i][0];
            y = array[i][1];
            titikSekarang = Math.pow(x, 2) + Math.pow(y, 2);
            temp = Math.sqrt(titikSekarang);

            array2[i] = temp;
        }

        Arrays.sort(array2);

        for (double i : array2) {
            if (i == 0.0) {
                continue;
            }
            System.out.println(i);
            break;
        }
    }
}