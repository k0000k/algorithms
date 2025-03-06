import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int answer = 0;
        int r = 1;
        for (Character ch : input.toCharArray()) {
            int val = ch - 96;
            answer += val * r;
            r *= 31;
        }
        System.out.println(answer % 1234567891);
    }
}