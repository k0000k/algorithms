import java.io.*;
import java.util.*;

class Diff implements Comparable<Diff> {
    int x; // x와 x+1 사이
    int val;

    public Diff(int x, int val) {
        this.x = x;
        this.val = val;
    }

    @Override
    public int compareTo(Diff o) {
        return o.val - this.val;
    }

    @Override
    public String toString() {
        return x + " " + val;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] students;
    public static PriorityQueue<Diff> diffs = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        students = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            diffs.add(new Diff(i, students[i + 1] - students[i]));
        }

        int[] partitions = new int[k - 1];
        for (int i = 0; i < k - 1; i++) {
            partitions[i] = diffs.poll().x;
        }

        Arrays.sort(partitions);
//        for (int i = 0; i < partitions.length; i++) {
//            System.out.println(partitions[i]);
//        }

        int cost = 0;
        int minIdx = 0;
        for (int partitionIdx : partitions) {
//            System.out.println(minIdx + " " + partitionIdx);
            cost += students[partitionIdx] - students[minIdx];
            minIdx = partitionIdx + 1;
        }
        cost += students[n - 1] - students[minIdx];

        System.out.println(cost);
    }

}