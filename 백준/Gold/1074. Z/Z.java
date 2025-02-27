import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 2^n 줄
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        find((int) Math.pow(2, n), r, c, 0);
    }

    public static void find(int length, int x, int y, int answer) {
        if (length == 1) {
            System.out.println(answer);
            return;
        }

        int centerIdx = length / 2;
        boolean flagX = x < centerIdx;
        boolean flagY = y < centerIdx;
        int oneNodeCnt = length * length / 4;

        int newLength = length / 2;
        if (flagX && flagY) { // 1구역
            find(newLength, x, y, answer);
        }
        else if (flagX) { // 2구역
            find(newLength, x, y - newLength, answer + oneNodeCnt);
        }
        else if (flagY) { // 3구역
            find(newLength, x - newLength, y, answer + oneNodeCnt * 2);
        }
        else { // 4구역
            find(newLength, x - newLength, y - newLength, answer + oneNodeCnt * 3);
        }
    }
}
