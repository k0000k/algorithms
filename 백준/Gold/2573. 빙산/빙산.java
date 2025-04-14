import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] ice;
    public static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ice = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (isOne()) {
            answer++;
            int[][] diff = new int[n][m];
            for (int i = 0; i < ice.length; i++) {
                for (int j = 0; j < ice[0].length; j++) {
                    if (ice[i][j] > 0) {
                        int cnt = 0;
                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (isRange(x, y) && ice[x][y] == 0) {
                                cnt++;
                            }
                        }
                        diff[i][j] = Math.min(cnt, ice[i][j]);
                    }
                }
            }
            applyDiff(diff);
//            printArr();
        }

        for (int i = 0; i < ice.length; i++) {
            for (int j = 0; j < ice[0].length; j++) {
                if (ice[i][j] > 0) {
                    System.out.println(answer);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    private static boolean isOne() {
        boolean[][] visited = new boolean[ice.length][ice[0].length];
        int result = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (ice[i][j] > 0 && !visited[i][j]) {
                    result += 1;
                    queue.addLast(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] node = queue.pollFirst();
                        for (int[] dir : directions) {
                            int x = node[0] + dir[0];
                            int y = node[1] + dir[1];
                            if (isRange(x, y) && ice[x][y] > 0 && !visited[x][y]) {
                                queue.addLast(new int[]{x, y});
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
        }
        if (result == 1) {
            return true;
        }
        return false;
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < ice.length) && (y >= 0) && (y < ice[0].length);
    }

    private static void applyDiff(int[][] diff) {
        for (int i = 0; i < diff.length; i++) {
            for (int j = 0; j < diff[0].length; j++) {
                if (ice[i][j] > 0) {
                    ice[i][j] -= diff[i][j];
                }
            }
        }
    }

}
