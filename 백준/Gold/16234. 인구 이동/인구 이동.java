import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] peoples;
    public static int l;
    public static int r;
    public static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        peoples = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                peoples[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int answer = 0;
        while (true) {
            boolean flag = false;
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && isOpen(i, j)) {
                        flag = true;
                        bfs(i, j, visited);
                    }
                    else {
                        visited[i][j] = true;
                    }
                }
            }
            if (!flag) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static boolean isOpen(int i, int j) {
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (isRange(x, y)) {
                int diff = Math.abs(peoples[i][j] - peoples[x][y]);
                if (diff >= l && diff <= r) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < peoples.length) && (y >= 0) && (y < peoples[0].length);
    }

    private static void bfs(int i, int j, boolean[][] visited) {
        ArrayList<int[]> update = new ArrayList<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {i, j});
        update.add(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();
//            System.out.println(node[0] + " " + node[1]);
            for (int[] dir : directions) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if (isRange(x, y) && !visited[x][y]) {
                    int diff = Math.abs(peoples[node[0]][node[1]] - peoples[x][y]);
                    if (diff >= l && diff <= r) {
                        update.add(new int[] {x, y});
                        queue.addLast(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        doUpdate(update);
    }

    private static void doUpdate(ArrayList<int[]> update) {
        int sum = 0;
        for (int[] node: update) {
            sum += peoples[node[0]][node[1]];
        }

        int result = sum / update.size();
        for (int[] node: update) {
            peoples[node[0]][node[1]] = result;
        }
    }
}
