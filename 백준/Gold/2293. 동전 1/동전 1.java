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
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(values);
        dp = new int[k + 1];
        for (Integer v : values) {
            if (v > k) {
                continue;
            }
            dp[v] += 1;
            for (int i = 1; i < k + 1; i++) {
                if (i + v < k + 1) {
                    dp[i + v] += dp[i];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
