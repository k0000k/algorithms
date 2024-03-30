import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int checkRange(int num, int n) {
        while (num < 0) {
            num += n;
        }
        while (num > n - 1) {
            num -= n;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input);

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{n - 1, 0});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 2, 0});
        clouds.add(new int[]{n - 2, 1});

        int[][] direction = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            stringTokenizer = new StringTokenizer(input);
            int[] newLine = new int[n];
            int j = 0;
            while(stringTokenizer.hasMoreTokens()) {
                newLine[j++] = Integer.parseInt(stringTokenizer.nextToken());
            }
            board[i] = newLine;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine();
            stringTokenizer = new StringTokenizer(input);
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int s = Integer.parseInt(stringTokenizer.nextToken());

            for (int[] cloud : clouds) {
                cloud[0] = checkRange(direction[d - 1][0] * s + cloud[0], n);
                cloud[1] = checkRange(direction[d - 1][1] * s + cloud[1], n);
            }

            int[][] cloudMap = new int[n][n];
            for (int[] cloud: clouds) {
                cloudMap[cloud[0]][cloud[1]] = 1;
                board[cloud[0]][cloud[1]] += 1;
            }

            for (int[] cloud : clouds) {
                int count = 0;
                for (int j = 1; j <= 7; j += 2) {
                    int x = cloud[0] + direction[j][0];
                    int y = cloud[1] + direction[j][1];
                    if (((0 <= x) && (x <= n - 1)) && ((0 <= y) && (y <= n - 1))) {
                        if (board[x][y] > 0) {
                            count++;
                        }
                    }
                }
                board[cloud[0]][cloud[1]] += count;
            }

            ArrayList<int[]> newCloud = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[j][k] >= 2) {
                        if (cloudMap[j][k] != 1) {
                            board[j][k] -= 2;
                            newCloud.add(new int[]{j, k});
                        }
                    }
                }
            }

            clouds = newCloud;

        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += board[i][j];
            }
        }

        System.out.println(answer);
    }
}