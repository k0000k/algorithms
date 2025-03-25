import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int k;
    public static int[] nums;
    public static ArrayDeque<Integer> sequence = new ArrayDeque<>();
    public static HashMap<Integer, Integer> counter = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (addPossible(num)) {
                sequence.addLast(num);
                int past = counter.getOrDefault(num, 0);
                counter.put(num, past + 1);
                if (sequence.size() > maxLength) {
                    maxLength = sequence.size();
                }
                continue;
            }
            i--;
            int pastKey = sequence.pollFirst();
            int past = counter.get(pastKey);
            if (past - 1 == 0) {
                counter.remove(pastKey);
            }
            else {
                counter.put(pastKey, past - 1);
            }
        }

        System.out.println(maxLength);
    }

    private static boolean addPossible(int num) {
        if (!counter.containsKey(num)) {
            return true;
        }
        if (counter.get(num) == k) {
            return false;
        }
        return true;
    }
}
