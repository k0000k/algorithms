import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            makeIntArr(i, input);
        }

        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j]) {
//                    System.out.println(i + " " + j);
                    findSection(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    private static void findSection(int x, int y) {
        if (visited[x][y]) { // 이미 방문한 칸일때
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int afterX = x + directions[i][0];
            int afterY = y + directions[i][1];
            if (isRange(afterX, afterY)) {
                int dirVal = map[afterX][afterY];
                if (Math.abs(dirVal - i) == 2) {
                    findSection(afterX, afterY);
                }
            }
        }

        int dirIdx = map[x][y];
        int afterX = x + directions[dirIdx][0];
        int afterY = y + directions[dirIdx][1];
        if (!visited[afterX][afterY]) {
            findSection(afterX, afterY);
        }
    }

    private static boolean isRange(int x, int y) {
        return (x < map.length) && (x >= 0) && (y < map[0].length) && (y >= 0);
    }

    private static void makeIntArr(int i, String[] input) {
        for (int j = 0; j < input.length; j++) {
            int value = -1;
            if (input[j].equals("U")) {
                value = 0;
            }
            else if (input[j].equals("L")) {
                value = 1;
            }
            else if (input[j].equals("D")) {
                value = 2;
            }
            else if (input[j].equals("R")) {
                value = 3;
            }
            map[i][j] = value;
        }
    }

}