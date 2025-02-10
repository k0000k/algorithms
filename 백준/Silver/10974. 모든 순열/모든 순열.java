import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        boolean[] selected = new boolean[n];
        int[] current = new int[n];
        permutation(n, selected, current);
    }

    private static void permutation(int remain, boolean[] selected, int[] current) {
        if (remain == 0) {
            for (int num : current) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if (!selected[i - 1]) {
                boolean[] newSelected = Arrays.copyOf(selected, n);
                newSelected[i - 1] = true;
                int[] newCurrent = Arrays.copyOf(current, n);
                newCurrent[n - remain] = i;
                permutation(remain - 1, newSelected, newCurrent);
            }

        }
    }
}
