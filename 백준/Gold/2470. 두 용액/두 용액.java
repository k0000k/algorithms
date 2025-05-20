import java.io.*;
import java.util.*;

class Liquid implements Comparable<Liquid> {
    int val;
    int abs;

    public Liquid(int val) {
        this.val = val;
        this.abs = Math.abs(val);
    }

    @Override
    public int compareTo(Liquid o) {
        if (this.abs == o.abs) {
            return this.val - o.val;
        }
        return this.abs - o.abs;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Liquid[] liquids;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        liquids = new Liquid[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquids[i] = new Liquid(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(liquids);

        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < n - 1; i++) {
            int sum = Math.abs(liquids[i].val + liquids[i + 1].val);
            if (sum < min) {
                min = sum;
                idx = i;
            }
        }

        int val1 = liquids[idx].val;
        int val2 = liquids[idx + 1].val;

        System.out.println(Math.min(val1, val2) + " " + Math.max(val1, val2));
    }
}
