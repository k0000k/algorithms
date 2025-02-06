import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] numbers;
    public static int m;
    public static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        numbers = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                numbers[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int oper = Integer.parseInt(st.nextToken());
            if (oper == 1) operation1();
            else if (oper == 2) operation2();
            else if (oper == 3) operation3();
            else if (oper == 4) operation4();
            else if (oper == 5) operation5();
            else if (oper == 6) operation6();
        }

        printAnswer();
    }

    // 상하반전
    private static void operation1() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = numbers[j][i];
                numbers[j][i] = numbers[n - 1 - j][i];
                numbers[n - 1 - j][i] = temp;
            }
        }
    }

    // 좌우반전
    private static void operation2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = numbers[i][j];
                numbers[i][j] = numbers[i][m - 1 - j];
                numbers[i][m - 1 - j] = temp;
            }
        }
    }

    // 오른쪽 90도 회전 -> 행열전환 이후 좌우반전 수행
    private static void operation3() {
        // 행열전환
        int[][] newArr = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newArr[j][i] = numbers[i][j];
            }
        }
        numbers = newArr;
        int temp = n;
        n = m;
        m = temp;
        operation2(); // 좌우반전
    }

    // 왼쪽 90도 회전 -> 반대로 행열전환 이후 상하반전 수행
    private static void operation4() {
        // 행열전환
        int[][] newArr = new int[m][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                newArr[j][i] = numbers[i][j];
            }
        }
        numbers = newArr;
        int temp = n;
        n = m;
        m = temp;
        operation1(); // 상하반전
    }

    private static void operation5() {
        int[][] newArr = new int[n][m];
        // 1 -> 2
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i][(m / 2) + j] = numbers[i][j];
            }
        }

        // 2 -> 3
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[(n / 2) + i][j] = numbers[i][j];
            }
        }

        // 3 -> 4
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[i][j - (m / 2)] = numbers[i][j];
            }
        }

        // 4 -> 1
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i - (n / 2)][j] = numbers[i][j];
            }
        }

        numbers = newArr;

    }

    private static void operation6() {
        int[][] newArr = new int[n][m];

        // 1 -> 4
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i + (n / 2)][j] = numbers[i][j];
            }
        }

        // 4 -> 3
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i][j + (m / 2)] = numbers[i][j];
            }
        }

        // 3 -> 2
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[i - (n / 2)][j] = numbers[i][j];
            }
        }

        // 2 -> 1
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[i][j - (m / 2)] = numbers[i][j];
            }
        }

        numbers = newArr;

    }

    private static void printAnswer() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }
}
