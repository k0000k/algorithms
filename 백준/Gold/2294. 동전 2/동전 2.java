import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] values;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        values = new int[n];
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value < k + 1) {
                values[i] = value;
                dp[value] = 1;
            }
        }

        for (int i = 0; i < k + 1; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 0; j < n; j++) {
                    int value = values[j];
                    if (i + value < k + 1) {
                        dp[i + value] = Math.min(dp[i + value], dp[i] + 1);
                    }
                }
            }
        }

        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[k]);
        }
    }
}
