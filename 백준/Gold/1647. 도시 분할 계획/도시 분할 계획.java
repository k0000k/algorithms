import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    int cost;
    int[] house;

    public Vertex(int cost, int[] house) {
        this.cost = cost;
        this.house = house;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return this.cost + " " + this.house[0] + " " + this.house[1];
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] parent;
    public static PriorityQueue<Vertex> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Vertex(cost, new int[]{a, b}));
        }

        int cnt = 0;
        int answer = 0;
        while (cnt < n - 2) {
            Vertex vertex = pq.poll();
            int house1 = vertex.house[0];
            int house2 = vertex.house[1];

            if (house1 == house2) {
                continue;
            }

            if (find(house1) != find(house2)) {
//                System.out.println(vertex.toString());
                union(house1, house2);
                cnt++;
                answer += vertex.cost;
            }
        }
        System.out.println(answer);
    }

    private static int find(int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        parent[Math.max(parentA, parentB)] = Math.min(parentA, parentB);
    }

    private static boolean countRoot() {
        int count = 0;
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
            if (count == 3) {
//                System.out.println(count);
                return true;
            }
        }
//        System.out.println(count);
        return false;
    }

}
