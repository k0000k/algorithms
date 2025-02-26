import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer> orders = new ArrayList<>();
    public static HashSet<Integer> set = new HashSet<>();
    public static HashMap<Integer, Integer> answers = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            orders.add(num);
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int answer = 0;
        for (Integer num : list) {
            answers.put(num, answer);
            answer++;
        }

        for (Integer num : orders) {
            sb.append(answers.get(num) + " ");
        }
        
        System.out.println(sb);
    }
}
