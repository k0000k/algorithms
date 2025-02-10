import java.io.*;

public class Main {
    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();

//    public static int hanoi(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        return 2 * hanoi(n - 1) + 1;
//    }

    public static void hanoi1to3(int n) {
        answer++;
        if (n == 1) {
            sb.append("1 3\n");
//            System.out.println(1 + " " + 3);
            return;
        }
        hanoi1to2(n - 1);
        sb.append("1 3\n");
//        System.out.println(1 + " " + 3);
        hanoi2to3(n - 1);
    }

    public static void hanoi1to2(int n) {
        answer++;
        if (n == 1) {
            sb.append("1 2\n");
//            System.out.println(1 + " " + 2);
            return;
        }
        hanoi1to3(n - 1);
        sb.append("1 2\n");
//        System.out.println(1 + " " + 2);
        hanoi3to2(n - 1);
    }

    public static void hanoi3to2(int n) {
        answer++;
        if (n == 1) {
            sb.append("3 2\n");
//            System.out.println(3 + " " + 2);
            return;
        }
        hanoi3to1(n - 1);
        sb.append("3 2\n");
//        System.out.println(3 + " " + 2);
        hanoi1to2(n - 1);
    }

    public static void hanoi3to1(int n) {
        answer++;
        if (n == 1) {
            sb.append("3 1\n");
//            System.out.println(3 + " " + 1);
            return;
        }
        hanoi3to2(n - 1);
        sb.append("3 1\n");
//        System.out.println(3 + " " + 1);
        hanoi2to1(n - 1);
    }

    public static void hanoi2to1(int n) {
        answer++;
        if (n == 1) {
            sb.append("2 1\n");
//            System.out.println(2 + " " + 1);
            return;
        }
        hanoi2to3(n - 1);
        sb.append("2 1\n");
//        System.out.println(2 + " " + 1);
        hanoi3to1(n - 1);
    }

    public static void hanoi2to3(int n) {
        answer++;
        if (n == 1) {
            sb.append("2 3\n");
//            System.out.println(2 + " " + 3);
            return;
        }
        hanoi2to1(n - 1);
        sb.append("2 3\n");
//        System.out.println(2 + " " + 3);
        hanoi1to3(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
//        System.out.println(hanoi(k));

        hanoi1to3(k);
        System.out.println(answer);
        System.out.print(sb);
    }
}
