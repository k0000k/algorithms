import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] products;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        products = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[k + 1][n];
        for (int i = products[0][0]; i < dp.length; i++) {
            dp[i][0] = products[0][1];
        }

        for (int j = 1; j < dp[0].length; j++) {
            int weight = products[j][0];
            int value = products[j][1];
            for (int i = 0; i < dp.length; i++) {
                if (i >= weight) {
                    dp[i][j] = Math.max(dp[i - weight][j - 1] + value, dp[i][j - 1]);
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[k][n - 1]);
    }

    private static void printArr() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
