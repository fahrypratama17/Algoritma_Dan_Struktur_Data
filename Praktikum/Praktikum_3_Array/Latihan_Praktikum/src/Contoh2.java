import java.util.Scanner;

public class Contoh2 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        int jmlKunci = input.nextInt();

        int[] array = new int[jmlKunci];

        for (int i = 0; i < jmlKunci; i++) {
            array[i] = input.nextInt();
        }

        int target = input.nextInt(), angkaPertama = 0, angkaKedua = 0;

        for (int i = 0; i < array.length; i++){
            angkaPertama = array[i];

            for (int j = i + 1; j < array.length; j++) {
                angkaKedua = array[j];
                if (angkaPertama + angkaKedua == target) {
                    System.out.println("[" + i + ", " + j + "]");
                }
            }
        }
    }
}
