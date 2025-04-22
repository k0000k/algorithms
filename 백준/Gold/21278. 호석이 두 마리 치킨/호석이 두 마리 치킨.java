import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] city;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        city = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(city[i], 101);
            city[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            city[a - 1][b - 1] = 1;
            city[b - 1][a - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int current = city[i][j];
                for (int k = 0; k < n; k++) {
                    int after = city[i][k] + city[k][j];
                    if (current > after) {
                        city[i][j] = after;
                        city[j][i] = after;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int[] chickens = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int result = 0;
                for (int k = 0; k < n; k++) {
                    int shortest = Math.min(city[k][i], city[k][j]);
                    result += (2 * shortest);
                }
                if (result < min) {
                    min = result;
                    chickens[0] = i;
                    chickens[1] = j;
                }
            }
        }

        System.out.println((chickens[0] + 1) + " " + (chickens[1] + 1) + " " + min);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(city[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
