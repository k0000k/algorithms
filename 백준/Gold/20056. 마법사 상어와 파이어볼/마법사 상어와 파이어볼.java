import java.io.*;
import java.util.*;

class Block {
    ArrayList<FireBall> fireBalls = new ArrayList<>();

    @Override
    public String toString() {
        return String.valueOf(fireBalls.size());
    }
}

class FireBall {
    int weight;
    int speed;
    int directionIdx;

    FireBall(int weight, int speed, int directionIdx) {
        this.weight = weight;
        this.speed = speed;
        this.directionIdx = directionIdx;

    }
}

public class Main
{

    public static Block[][] board;
    public static int[][] directions = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static int n;

//    public static void printBoard() {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                System.out.print(board[i][j].toString() + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------");
//    }

    // 4개로 나눠진 직후 바로 이동하므로 1개 이상일수도 있다.
    public static void moveFireBalls() {
        ArrayList<FireBall> fireBalls = new ArrayList<>();
        ArrayList<int[]> locations = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].fireBalls.size() != 0) {
                    for (FireBall thisFireBall: board[i][j].fireBalls) {
                        int x = checkRange(i + directions[thisFireBall.directionIdx][0] * thisFireBall.speed);
                        int y = checkRange(j + directions[thisFireBall.directionIdx][1] * thisFireBall.speed);
                        locations.add(new int[] {x, y});
                        fireBalls.add(thisFireBall);

                    }
                    board[i][j].fireBalls = new ArrayList<>();
                }
            }
        }
        applyMove(fireBalls, locations);
    }

    public static void applyMove(ArrayList<FireBall> fireBalls, ArrayList<int[]> locations) {
        for (int i = 0; i < fireBalls.size(); i++) {
            int x = locations.get(i)[0];
            int y = locations.get(i)[1];
            board[x][y].fireBalls.add(fireBalls.get(i));
        }
    }

    public static int checkRange(int num) {
        while (num < 0) {
            num += n;
        }
        while (num > n - 1) {
            num -= n;
        }
        return num;
    }

    public static void splitFireBalls() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].fireBalls.size() > 1) {
                    int newWeight = 0;
                    int newSpeed = 0;
                    for (FireBall thisFireBall: board[i][j].fireBalls) {
                        newWeight += thisFireBall.weight;
                        newSpeed += thisFireBall.speed;
                    }
                    newWeight /= 5;
                    newSpeed /= board[i][j].fireBalls.size();
                    boolean isSame = verifyDirection(board[i][j].fireBalls);
                    board[i][j].fireBalls = new ArrayList<>();
                    makeFireBalls(isSame, newWeight, newSpeed, i, j);
                }
            }
        }
    }

    public static void makeFireBalls(boolean isSame, int newWeight, int newSpeed, int x, int y) {
        if (newWeight == 0) {
            return;
        }

        int direction = 1;
        if (isSame) {
            direction -= 1;
        }
        for (int i = 0; i < 4; i++) {
            board[x][y].fireBalls.add(new FireBall(newWeight, newSpeed, direction));
            direction += 2;
        }
    }

    public static boolean verifyDirection(ArrayList<FireBall> fireBalls) {
        int standard = fireBalls.get(0).directionIdx % 2;
        for (FireBall fireBall: fireBalls) {
            if (fireBall.directionIdx % 2 != standard) {
                return false;
            }
        }
        return true;
    }

    public static int sumFireBalls() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].fireBalls.size() > 0) {
                    for (FireBall fireBall: board[i][j].fireBalls) {
                        result += fireBall.weight;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // board는 위아래 좌우가 연결
        board = new Block[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new Block();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1].fireBalls.add(new FireBall(w, s, d));
        }

        for (int i = 0; i < k; i++) {
            moveFireBalls(); // 시간초과 뜨면 여기서 검사할 부분을 찾기
            splitFireBalls();
        }

        int result = sumFireBalls();
        System.out.println(result);
    }
}
