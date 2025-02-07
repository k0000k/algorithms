import java.io.*;
import java.util.*;

class Node {
    public int x;
    public int y;
    public int day;

    public Node(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int[][] tomatoes;
    public static ArrayDeque<Node> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        tomatoes = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                tomatoes[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 1 && isStart(i, j)) {
                    deque.addLast(new Node(i, j, 1));
                }
            }
        }



        int answer = 0;
        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            for (int[] dir : directions) {
                int afterX = node.x + dir[0];
                int afterY = node.y + dir[1];
                if (isValidate(afterX, afterY) && tomatoes[afterX][afterY] == 0) {
                    tomatoes[afterX][afterY] = 1;
                    deque.addLast(new Node(afterX, afterY, node.day + 1));
                    if (answer < node.day + 1) {
                        answer = node.day + 1;
                    }
                }
            }

        }

        boolean flag = false;
        for (int[] arr : tomatoes) {
            for (int num : arr) {
                if (num == 0) {
                    flag = true;
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        }
        else if (answer == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(answer - 1);
        }

    }

    private static boolean isValidate(int x, int y) {
        return (x >= 0) && (x < tomatoes.length) && (y >= 0) && (y < tomatoes[0].length);
    }

    private static boolean isStart(int x, int y) {
        for (int[] dir : directions) {
            int afterX = x + dir[0];
            int afterY = y + dir[1];
            if (isValidate(afterX, afterY) && tomatoes[afterX][afterY] == 0) {
                return true;
            }
        }
        return false;
    }
    private static void printArr() {
        for (int i = 0; i < tomatoes.length; i++) {
            for (int j = 0; j < tomatoes[0].length; j++) {
                System.out.print(tomatoes[i][j] + " ");
            }
            System.out.println();
        }
    }
}
