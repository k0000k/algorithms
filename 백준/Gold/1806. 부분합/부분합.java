import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = n + 1;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            for ( ; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    if (j - i + 1 < answer) {
                        answer = j - i + 1;
                    }
                    sum -= nums[i];
                    sum -= nums[j];
                    break;
                }
            }
        }

        if (answer == n + 1) {
            System.out.println(0);
        }
        else {
            System.out.println(answer);
        }
    }
}
