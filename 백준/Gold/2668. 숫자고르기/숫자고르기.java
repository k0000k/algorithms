import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] nums;
    public static boolean[] visited;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (i == nums[i]) {
                answer.add(i);
            }
        }

        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                ArrayList<Integer> result = dfs(i, new ArrayList<>(), new boolean[n + 1]);
                if (!result.isEmpty()) {
                    for (Integer num : result) {
                        visited[num] = true;
                        answer.add(num);
                    }
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer num : answer) {
            System.out.println(num);
        }
    }

    private static ArrayList<Integer> dfs(int i, ArrayList<Integer> result, boolean[] currentVisited) {
        if (i == nums[i]) {
            return new ArrayList<>();
        }
        if (!currentVisited[i] && result.contains(nums[i])) {
            return new ArrayList<>();
        }
        if (currentVisited[i]) {
            return result;
        }
        currentVisited[i] = true;
        result.add(nums[i]);
        return dfs(nums[i], result, currentVisited);
    }

}
