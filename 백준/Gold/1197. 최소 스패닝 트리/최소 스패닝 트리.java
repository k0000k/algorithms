import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int[] vertexes;
    int val;

    public Edge(int[] vertexes, int val) {
        this.vertexes = vertexes;
        this.val = val;
    }

    @Override
    public int compareTo(Edge o) {
        return this.val - o.val;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(new int[]{a - 1, b - 1}, c));
        }

        init(v);

        int answer = 0;
        int cnt = 0;
        while (!edges.isEmpty() && cnt < v - 1) {
            Edge edge = edges.poll();
            int v1 = edge.vertexes[0];
            int v2 = edge.vertexes[1];

            if (v1 == v2) {
                continue;
            }

            if (find(v1) != find(v2)) {
                union(v1, v2);
                answer += edge.val;
                cnt += 1;
            }
        }
        System.out.println(answer);
    }

    private static int find(int node) {
        if (node != parent[node]) {
//            return find(parent[node]);
            parent[node] = find(parent[node]);
            return parent[node];
        }
        return node;
    }

    private static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 > node2) {
            parent[node1] = node2;
        }
        else {
            parent[node2] = node1;
        }
    }

    private static void init(int v) {
        parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
    }
}