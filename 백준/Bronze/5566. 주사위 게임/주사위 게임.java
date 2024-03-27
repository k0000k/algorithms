import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = bufferedReader.readLine();
            board.add(Integer.parseInt(str));
        }

        ArrayList<Integer> dice = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            str = bufferedReader.readLine();
            dice.add(Integer.parseInt(str));
        }

        int pos = 1;
        int result = 0;
        for (Integer num : dice) {
            pos += num;
            result++;
            if (pos >= n) {
                break;
            }
            Integer instruction = board.get(pos - 1);
            pos += instruction;
            if (pos >= n) {
                break;
            }
        }

        System.out.println(result);
    }
}