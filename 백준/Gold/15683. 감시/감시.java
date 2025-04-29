import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static int[][] office;
    public static ArrayList<int[]> nodes = new ArrayList<>();
    public static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        office = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] > 0 && office[i][j] < 6) {
                    nodes.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        backtracking(0, office);
        System.out.println(answer);
    }

    private static void backtracking(int cnt, int[][] arr) {
        if (cnt >= nodes.size()) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) {
                        result += 1;
                    }
                }
            }
            answer = Math.min(answer, result);
            return;
        }

        int[] node = nodes.get(cnt);
        int val = node[2];
        int x = node[0];
        int y = node[1];
        if (val == 1) {
            for (int[] dir : directions) {
                int[][] afterOffice = copyArr(arr);
                move(x, y, afterOffice, dir);
                backtracking(cnt + 1, afterOffice);
            }
        }
        else if (val == 2) {
            for (int i = 0; i < 2; i++) {
                int[][] afterOffice = copyArr(arr);
                move(x, y, afterOffice, directions[i]);
                move(x, y, afterOffice, directions[i + 2]);
                backtracking(cnt + 1, afterOffice);
            }
        }
        else if (val == 3) {
            for (int i = 0; i < 4; i++) {
                int[][] afterOffice = copyArr(arr);
                move(x, y, afterOffice, directions[i]);
                move(x, y, afterOffice, directions[(i + 1) % 4]);
                backtracking(cnt + 1, afterOffice);
            }
        }
        else if (val == 4) {
            for (int i = 0; i < 4; i++) {
                int[][] afterOffice = copyArr(arr);
                for (int j = 0; j < 4; j++) {
                    if (i == j) {
                        continue;
                    }
                    move(x, y, afterOffice, directions[j]);
                }
                backtracking(cnt + 1, afterOffice);
            }
        }
        else {
            int[][] afterOffice = copyArr(arr);
            for (int i = 0; i < 4; i++) {
                move(x, y, afterOffice, directions[i]);
            }
            backtracking(cnt + 1, afterOffice);
        }
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < office.length) && (y >= 0) && (y < office[0].length);
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return newArr;
    }

    private static void move(int x, int y, int[][] afterOffice, int[] dir) {
        while (isRange(x, y)) {
            if (afterOffice[x][y] == 0) {
                afterOffice[x][y] = -1;
            }
            else if (afterOffice[x][y] == 6) {
                break;
            }
            x += dir[0];
            y += dir[1];
        }
    }
}
