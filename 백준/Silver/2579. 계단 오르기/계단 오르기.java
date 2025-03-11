import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] steps;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        steps = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = steps[1];
        if (dp.length > 2) {
            dp[2] = steps[1] + steps[2];
        }

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 3] + steps[i - 1] + steps[i]);
            dp[i] = Math.max(dp[i], dp[i - 2] + steps[i]);
        }
        
        System.out.println(dp[n]);

    }
}
