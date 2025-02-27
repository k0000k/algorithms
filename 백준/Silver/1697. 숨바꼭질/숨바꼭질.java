import java.io.*;
import java.util.*;

class Location {
    int value;
    int time;

    public Location(int value, int time) {
        this.value = value;
        this.time = time;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<Location> queue = new ArrayDeque<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k <= n) {
            System.out.println(n - k);
            return;
        }

        visited = new boolean[2 * k];
        queue.add(new Location(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()) {
            Location location = queue.pollFirst();
            if (location.value == k) {
                System.out.println(location.time);
                break;
            }
            int[] move = new int[]{location.value, 1, -1};
            for (int num : move) {
                int idx = num + location.value;
                if (0 <= idx && idx < visited.length && !visited[idx]) {
                    queue.add(new Location(idx, location.time + 1));
                    visited[idx] = true;
                }
            }
        }
    }
}
