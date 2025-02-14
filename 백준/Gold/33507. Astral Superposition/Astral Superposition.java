import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] sky;
    public static int a;
    public static int b;
    public static int answer;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            answer = 0;

            sky = new int[n][n];
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split("");
                for (int k = 0; k < n; k++) {
                    String star = input[k];
                    if (star.equals("G")) {
                        sky[j][k] = 1;
                    }
                    else if (star.equals("B")) {
                        sky[j][k] = 2;
                    }
                    else {
                        sky[j][k] = 0;
                    }
                }
            }

            if (handleBlack()) {
                handleGray();
                System.out.println(answer);
            }
            else {
                System.out.println(-1);
            }

        }
    }

    private static boolean handleBlack() {
        for (int i = 0; i < sky.length; i++) {
            for (int j = 0; j < sky[0].length; j++) {
                if (sky[i][j] == 2) {
                    if (i - b < 0 || j - a < 0 || sky[i - b][j - a] == 0) {
                        return false;
                    }
                    sky[i - b][j - a] -= 1;
                    sky[i][j] -= 1;
                    answer += 1;
                }
            }
        }
        return true;
    }

    private static void handleGray() {
        for (int i = 0; i < sky.length; i++) {
            for (int j = 0; j < sky[0].length; j++) {
                if (sky[i][j] == 1) {
                    answer += 1;
                    if (i + b < sky.length && j + a < sky.length && sky[i + b][j + a] == 1) {
                        sky[i + b][j + a] = 0;
                    }
                }
            }
        }
    }
}
