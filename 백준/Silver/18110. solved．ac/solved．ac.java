import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        int cutOff = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = cutOff; i < n - cutOff; i++) {
            sum += nums[i];
        }

        int answer = Math.round((float) sum / (n - 2 * cutOff));
        System.out.println(answer);
    }
}
