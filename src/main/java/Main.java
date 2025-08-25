import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            String numberStr = Integer.toString(number);

            char[] charsArray = numberStr.toCharArray();
            Arrays.sort(charsArray);

            if (charsArray[0] == '0') {
                for (int i = 1; i < charsArray.length; i++) {
                    if (charsArray[i] != '0') {
                        char temp = charsArray[0];
                        charsArray[0] = charsArray[i];
                        charsArray[i] = temp;
                        break;
                    }
                }
            }
            int result = Integer.parseInt(String.valueOf(charsArray));
            System.out.println(result);
        }








    }
}
