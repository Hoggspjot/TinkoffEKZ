import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int arraySize = scanner.nextInt();

            int[] array = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                array[i] = scanner.nextInt();
            }

            Map<Integer, Long> counter = Arrays.stream(array)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            long MOD = 1000000007L;
            long result = 1;
            for (long f : counter.values()) {
                result = (result * (1L + f)) % MOD;
            }
            long modResult = (result - 1 + MOD) % MOD;
            System.out.println(modResult);

        }
    }
}
