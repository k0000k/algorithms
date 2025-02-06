import java.io.*;
import java.util.*;

class Use implements Comparable<Use>{
    public int start;
    public int end;

    public Use(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Use o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static ArrayList<Use> uses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            uses.add(new Use(start, end));
        }

        Collections.sort((List) uses);

        Use currentUse = uses.get(0);
        int answer = 1;
        for (int i = 1; i < uses.size(); i++) {
            if (currentUse.end <= uses.get(i).start) {
                answer++;
                currentUse = uses.get(i);
            }
        }
        System.out.println(answer);
    }
}
