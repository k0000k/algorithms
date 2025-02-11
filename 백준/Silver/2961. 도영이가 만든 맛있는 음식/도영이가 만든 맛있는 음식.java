import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] ingredients;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ingredients = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        findMinDiff(0, 1, 0);
        System.out.println(answer);
    }

    private static void findMinDiff(int idx, int sour, int spicy) {
        int diff = Math.abs(sour - spicy);
        if (sour != 1 && spicy != 0 && diff < answer) {
            answer = diff;
        }

        if (idx == ingredients.length) {
            return;
        }

        findMinDiff(idx + 1, sour * ingredients[idx][0], spicy + ingredients[idx][1]);
        findMinDiff(idx + 1, sour, spicy);
    }
}
