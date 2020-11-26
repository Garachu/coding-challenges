import java.util.Arrays;

public class Fibonacci {

    public static void main(String args[]) {
        int[] fibonacci = fibonacci(8);
        Arrays.stream(fibonacci).forEach(f -> System.out.print("\t" + f));
    }

    static int[] fibonacci(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }


    static int fibonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }
}
