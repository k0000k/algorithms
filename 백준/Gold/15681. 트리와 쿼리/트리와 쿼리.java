import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<ArrayList<Integer>> link = new ArrayList<>();
    public static int[] subTree;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        init(n);
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            link.get(u).add(v);
            link.get(v).add(u);
        }

        HashMap<Integer, Boolean> visited = new HashMap<>();
        makeTree(root, visited, 0);

        for (int i = 0; i < q; i++) {
            int newRoot = Integer.parseInt(br.readLine());
            System.out.println(subTree[newRoot]);
        }
    }

    private static void init(int n) {
        subTree = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            link.add(new ArrayList<>());
        }
    }

    private static int makeTree(int root, HashMap<Integer, Boolean> visited, int cnt) {
        ArrayList<Integer> node = link.get(root);
        visited.put(root, true);
        cnt++;
        boolean isLeaf = true;
        for (Integer idx : node) {
            if (!visited.getOrDefault(idx, false)) {
                isLeaf = false;
                cnt += makeTree(idx, visited, 0);
            }
        }
        if (isLeaf) {
            cnt = 1;
        }
        subTree[root] = cnt;
        return cnt;
    }
}
