import java.io.*;
import java.util.*;

class Box implements Comparable<Box> {
    int start;
    int dest;
    int weight;

    public Box(int start, int dest, int weight) {
        this.start = start;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Box o) {
        if (this.dest == o.dest) {
            return o.start - this.start;
        }
        return this.dest - o.dest;
    }

    @Override
    public String toString() {
        return start + " " + dest + " " + weight;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PriorityQueue<Box> pq = new PriorityQueue<>();
    public static boolean[] isFullArr;
    public static int[] truck;
    public static int c;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            pq.add(new Box(start, dest, cnt));
        }

        truck = new int[n + 1];
        isFullArr = new boolean[n + 1];

        int answer = 0;
        while (!pq.isEmpty()) {
            Box box = pq.poll();
            int start = box.start;
            int dest = box.dest;
            if (isNotFull(start, dest)) {
                int maxCapacity = findMax(start, dest);
                int possibleVal;
                if (box.weight <= maxCapacity) {
                    possibleVal = box.weight;
                }
                else {
                    possibleVal = maxCapacity;
                }
                answer += possibleVal;
                for (int i = start; i < dest; i++) {
                    truck[i] += possibleVal;
                    if (truck[i] == c) {
                        isFullArr[i] = true;
                    }
                }
            }
//            System.out.println(box);
//            printTruck();
//            System.out.println();
        }
        System.out.println(answer);
    }

    // 꽉 찬 칸이 있다면 false 리턴
    private static boolean isNotFull(int start, int dest) {
        for (int i = start; i < dest; i++) {
            if (isFullArr[i]) {
                return false;
            }
        }
        return true;
    }

    private static int findMax(int start, int dest) {
        int max = 0;
        for (int i = start; i < dest; i++) {
            if (truck[i] > max) {
                max = truck[i];
            }
        }
        return c - max;
    }

    private static void printTruck() {
        for (Integer num : truck) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
