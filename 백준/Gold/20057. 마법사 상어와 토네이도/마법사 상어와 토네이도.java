import java.io.*;
import java.util.*;

public class Main
{
    public static int[][] board;
    public static ArrayList<int[]> move;
    public static int x;
    public static int y;
    public static int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public static int outSands = 0;
    public static int[][] sandDirection = new int[][]{{-1}, {1}, {-1, 0}, {1, 0}, {1, 1, 0}, {-1, -1, 0}, {0, 0, 1}, {0, 0, -1}, {0, 0, 0}};
    public static int[] sandAmount = new int[]{1, 1, 7, 7, 2, 2, 10, 10, 5};
    // 현재의 방향 인덱스에서 +1 하면 왼쪽, -1 하면 오른쪽

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------");
    }

    public static void makeMoveArray(int n) {
        int directionIdx = 0;
        for (int i = 1; i <= n - 1; i++) {
            move.add(new int[]{i, directionIdx++ % 4});
            move.add(new int[]{i, directionIdx++ % 4});
        }
        move.add(new int[]{n - 1, directionIdx % 4});
    }

    public static void spreadSand(int directionIdx) {
        // 현재의 방향 인덱스에서 +1 하면 왼쪽, -1 하면 오른쪽
        // 모래 날리고 나서 이동하기

        // y칸 모래의 양 처리
        int afterX = x + directions[directionIdx][0];
        int afterY = y + directions[directionIdx][1];
        int totalSand = board[afterX][afterY];

        for (int i = 0; i < 9; i++) {
            // 좌표 찾기
            int sandX = x;
            int sandY = y;
            for (int d: sandDirection[i]) {
                int newIdx = checkDirectionRange(directionIdx + d);
                sandX += directions[newIdx][0];
                sandY += directions[newIdx][1];
            }

            //모래 양 계산
            int sand = totalSand * sandAmount[i] / 100;

            if (checkBoardRange(sandX, sandY)) {
                board[sandX][sandY] += sand;
            }
            else {
                outSands += sand;
            }

            board[afterX][afterY] -= sand;
        }

        // 알파 처리
        int alphaX = afterX + directions[directionIdx][0];
        int alphaY = afterY + directions[directionIdx][1];
        if (checkBoardRange(alphaX , alphaY)) {
            board[alphaX][alphaY] += board[afterX][afterY];
        }
        else {
            outSands += board[afterX][afterY];
        }
        board[afterX][afterY] = 0;

        x = afterX;
        y = afterY;

    }

    public static boolean checkBoardRange(int x, int y) {
        return (x >= 0 && x <= board.length - 1) && (y >= 0 && y <= board.length - 1);
    }

    public static int checkDirectionRange(int d) {
        while (d < 0) {
            d += 4;
        }
        while (d > 3) {
            d -= 4;
        }
        return d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move = new ArrayList<>();
        makeMoveArray(n);

        x = (n - 1) / 2;
        y = (n - 1) / 2;

        for (int[] moveInfo : move) {
            int length = moveInfo[0];
            int directionIdx = moveInfo[1];

            for (int i = 0; i < length; i++) {
                spreadSand(directionIdx);
            }
        }

        System.out.println(outSands);
    }
}
