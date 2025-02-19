import java.io.*;

public class Main {

    public static int n;
    public static long[][] allStairNumberDp;
    public static long[][] without0StairNumberDp;
    public static long[][] without9StairNumberDp;
    public static long[][] without09StairNumberDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        init();
        long allNum = calcDp(allStairNumberDp, 0, 9);
        long without0Num = calcDp(without0StairNumberDp, 1, 9);
        long without9Num = calcDp(without9StairNumberDp, 0, 8);
        long without09Num = calcDp(without09StairNumberDp, 1, 8);

//        System.out.println("result");
//        System.out.println(allNum);
//        System.out.println(without0Num);
//        System.out.println(without9Num);
//        System.out.println(without09Num);

        long answer = allNum - without0Num + 1000000000 - without9Num + 1000000000 + without09Num;
        System.out.println(answer % 1000000000);
    }

//    public static void main(String[] args) throws IOException {
//        long test = 0;
//        for (int i = 1; i <= 100; i++) {
//            n = i;
//            init();
//            long allNum = calcDp(allStairNumberDp, 0, 9);
//            long without0Num = calcDp(without0StairNumberDp, 1, 9);
//            long without9Num = calcDp(without9StairNumberDp, 0, 8);
//            long without09Num = calcDp(without09StairNumberDp, 1, 8);
//
////            System.out.println(allNum);
////            System.out.println(without0Num);
////            System.out.println(without9Num);
////            System.out.println(without09Num);
//
//            long answer = (allNum - without0Num + 1000000000) % 1000000000;
//            answer = (answer - without9Num + 1000000000) % 1000000000;
//            answer += without09Num;
////            System.out.println(answer % 1000000000);
//            test += answer % 1000000000;
//            System.out.println(answer % 1000000000);
//        }
////        System.out.println(test);
//    }

    private static void init() {
        allStairNumberDp = new long[10][n + 1];
        without0StairNumberDp = new long[10][n + 1];
        without9StairNumberDp = new long[10][n + 1];
        without09StairNumberDp = new long[10][n + 1];
        for (int i = 1; i < 10; i++) {
            allStairNumberDp[i][1] = 1;
            without0StairNumberDp[i][1] = 1;
            without9StairNumberDp[i][1] = 1;
            without09StairNumberDp[i][1] = 1;
        }
    }

    private static long calcDp(long[][] dp, int start, int end) {
        for (int j = 2; j < n + 1; j++) {
            for (int i = start; i <=end; i++) {
                if (i == start) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else if (i == end) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] + dp[i - 1][j - 1]) % 1000000000;
                }
            }
        }
//        printArr();
        long result = 0;
        for (int i = start; i <= end; i++) {
            result = (result + dp[i][n]) % 1000000000;
//            System.out.println(result);
        }
        return result;
    }


    private static void printArr() {
        for (int i = 0; i < allStairNumberDp.length; i++) {
            for (int j = 0; j < allStairNumberDp[0].length; j++) {
                System.out.print(allStairNumberDp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
