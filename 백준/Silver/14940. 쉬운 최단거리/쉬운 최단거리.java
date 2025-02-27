import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] answer;
    public static boolean[][] visited;
    public static ArrayDeque<int[]> queue = new ArrayDeque<>();
    public static int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    queue.add(new int[]{i, j});
                }
                else if (value == 0) {
                    visited[i][j] = true;
                }
                j++;
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
            int x = node[0];
            int y = node[1];
            visited[x][y] = true;
            for (int[] dir : directions) {
                int afterX = x + dir[0];
                int afterY = y + dir[1];
                if (!isRange(afterX, afterY)) {
                    continue;
                }
                if (visited[afterX][afterY]) {
                    continue;
                }
                answer[afterX][afterY] = answer[x][y] + 1;
                queue.add(new int[]{afterX, afterY});
                visited[afterX][afterY] = true;
            }
        }

        printArr(answer);
    }

    private static boolean isRange(int x, int y) {
        return (0 <= x) && (x < answer.length) && (0 <= y) && (y < answer[0].length);
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    System.out.print(-1 + " ");
                    continue;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
