import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] blocks;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        blocks = new int[w];
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int val = -1;
        int result = 0;
        for (int height = h; height >= 0; height--) {
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i] >= height) {
                    if (val == -1) {
                        val = i;
                        continue;
                    }
                    result += (i - val - 1);
                    val = i;
                }
            }
            val = -1;
        }
        System.out.println(result);
    }
}
