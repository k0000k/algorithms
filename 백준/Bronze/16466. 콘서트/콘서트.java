import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            nums[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int min = 1;
        for (int num: nums) {
            if (num != min) {
                break;
            }
            min++;
        }

        System.out.println(min);
    }
}