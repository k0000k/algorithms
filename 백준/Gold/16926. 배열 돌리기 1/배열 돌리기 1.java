import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] nums;
    public static int[][] answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[n][m];
        int rectCnt = Math.min(n, m) / 2; // 사각형의 갯수
        int rectLength = (n + m - 2) * 2; // 사각형의 둘레
        for (int i = 0; i < rectCnt; i++) {
            int moveCnt = r % rectLength;
            for (int j = i; j < nums.length - i; j++) {
                rotate(j, i, i, moveCnt);
                rotate(j, m - 1 - i, i, moveCnt);
            }
            for (int j = i; j < nums[0].length - i; j++) {
                rotate(i, j, i, moveCnt);
                rotate(n - 1 - i, j, i, moveCnt);
            }
            rectLength -= 8;
        }

        printAnswer();
    }

    private static void rotate(int x, int y, int i, int cnt) {
        int pastVal = nums[x][y];
        int currentCnt = 0;
        int startX = i;
        int startY = i;
        int endX = nums.length - 1 - i;
        int endY = nums[0].length - 1 - i;
        while (currentCnt < cnt) {
            if (x < endX && y == startY) {
                x++;
                currentCnt++;
            }
            else if (y < endY && x == endX) {
                y++;
                currentCnt++;
            }
            else if (x > startX && y == endY) {
                x--;
                currentCnt++;
            }
            else {
                y--;
                currentCnt++;
            }
        }
        answer[x][y] = pastVal;
    }

    private static void printAnswer() {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
