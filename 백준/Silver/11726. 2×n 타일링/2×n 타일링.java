import java.io.*;

public class Main {

    public static int[] answers = new int[1001];
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        answers[1] = 1;
        answers[2] = 2;
        int n = Integer.parseInt(br.readLine());
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                answers[i] = (answers[i - 1] + answers[i - 2]) % 10007;
            }
        }
        System.out.println(answers[n]);
    }
}