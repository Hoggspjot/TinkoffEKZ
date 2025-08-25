import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();

            for (int i = 0; i < size; i++) {
                int x = scanner.nextInt();
                int[] array = new int[x];
                for (int j = 0; j < array.length; j++) {
                    array[j] = scanner.nextInt();
                }
                Arrays.sort(array);

                boolean check = true;
                for (int j = 0; j < x; j++) {
                    if (array[j] > (j + 1)) {
                        check = false;
                        break;
                    }
                }
                if (!check) {
                    System.out.println("Second");
                    continue;
                }

                long moves = 0;
                for (int j = 0; j < x; j++) {
                    moves += ((j + 1) - array[j]);
                }

                if (moves % 2 == 1) {
                    System.out.println("First");
                } else {
                    System.out.println("Second");
                }
            }
        }
    }
}
