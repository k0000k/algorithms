import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] snows;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        snows = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snows[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snows);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                int firstHeight = snows[i] + snows[j];
                int start = i + 1;
                int end = j - 1;
                while (start < end) {
                    int secondHeight = snows[start] + snows[end];
                    answer = Math.min(answer, Math.abs(firstHeight - secondHeight));
                    if (secondHeight > firstHeight) {
                        end--;
                    }
                    else if (secondHeight < firstHeight) {
                        start++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
