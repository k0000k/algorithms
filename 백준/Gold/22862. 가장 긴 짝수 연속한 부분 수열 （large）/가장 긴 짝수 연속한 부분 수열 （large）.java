import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] nums;
    public static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken()) % 2;
        }

        int answer = 0;
        int[] cnts = new int[2];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                queue.addLast(0);
                cnts[0]++;
            }
            else if (nums[i] == 1) {
                if (cnts[1] < k) {
                    queue.addLast(1);
                    cnts[1]++;
                }
                else {
                    i--;
                    int val = queue.pollFirst();
                    cnts[val]--;
                }
            }
            if (queue.size() - cnts[1] > answer) {
                answer = queue.size() - cnts[1];
            }
        }
        System.out.println(answer);
    }
}
