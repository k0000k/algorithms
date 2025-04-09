import java.io.*;
import java.util.*;

class Node {
    int time;
    int location;

    public Node(int time, int location) {
        this.time = time;
        this.location = location;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<Node> queue = new ArrayDeque<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (end < start) {
            System.out.println(start - end);
            return;
        }

        visited = new boolean[100001];
        queue.addLast(new Node(0, start));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            int time = node.time;
            int location = node.location;
            if (location == end) {
                System.out.println(time);
                return;
            }

            int[] locations = new int[] {2 * location, location - 1, location + 1};
            int[] times = new int[] {time, time + 1, time + 1};
            for (int i = 0; i < locations.length; i++) {
                if (isRange(locations[i]) && !visited[locations[i]]) {
                    if (i == 0) {
                        queue.addFirst(new Node(times[i], locations[i]));
                    }
                    else {
                        queue.addLast(new Node(times[i], locations[i]));
                    }
                    visited[locations[i]] = true;
                }
            }
        }
    }

    private static boolean isRange(int idx) {
        return (idx >= 0) && (idx < visited.length);
    }
}
