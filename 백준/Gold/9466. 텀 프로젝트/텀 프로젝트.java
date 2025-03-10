import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] root;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            root = new int[n + 1];
            parent = new int[n + 1];
            for (int j = 1; j < n + 1; j++) {
                root[j] = j;
                parent[j] = j;
            }

            int answer = n;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int a = Integer.parseInt(st.nextToken());
                parent[j] = a;

                if (find(j) == -1 || find(a) == -1) {
                    continue;
                }
                else if (find(j) == find(a)) { // 사이클 감지되면 포함된 노드 검사
//                    printArr();
//                    union(j, a);
                    answer -= countNode(j);
                }
                else {
                    union(j, a);
                }
            }
            System.out.println(answer);
        }
    }

    private static void union(int parentIdx, int childIdx) {
        int a = find(parentIdx);
        int b = find(childIdx);
        root[Math.max(a, b)] = Math.min(a, b);
    }

    private static int find(int idx) {
        if (idx == -1) {
            return -1;
        }
        if (idx == root[idx]) {
            return idx;
        }
        root[idx] = find(root[idx]);
        return root[idx];
    }

    private static int countNode(int idx) {
        int result = 0;
//        printArr(root);
//        printArr(parent);
//        System.out.println(idx);
        while (root[idx] != -1) {
            result += 1;
            root[idx] = -1;
            idx = parent[idx];
        }
        return result;
    }

    private static void printArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}