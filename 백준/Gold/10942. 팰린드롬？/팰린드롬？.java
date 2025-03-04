import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] nums;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        init(n);

        StringBuilder answer = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = isPalindrome(s, e);
            if (value == 1) {
                answer.append(1 + "\n");
            }
            else {
                answer.append(0 + "\n");
            }
//            printArr();
        }
        System.out.print(answer);
    }
    
    private static void init(int n) {
        dp = new int[n + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < dp.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                dp[i][i + 1] = 1;
                continue;
            }
            dp[i][i + 1] = -1;
        }
    }

    // 0은 미정, 1은 yes, -1은 no
    private static int isPalindrome(int s, int e) {
        if (dp[s][e] == 0) {
            int pastVal = isPalindrome(s + 1, e - 1);
            if (pastVal == 1 && nums[s] == nums[e]) {
                dp[s][e] = 1;
                return 1;
            }
            dp[s][e] = -1;
        }
        return dp[s][e];
    }

    private static void printArr() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
