import java.io.*;
import java.util.*;

class Cycle {
    public int[] data;
    public int top = 0;
}

public class Main {
    public static Cycle[] cycles;

    public static void printTop() {
        for (Cycle cycle : cycles) {
            System.out.println(cycle.top);
        }
    }

    public static void rotate(int n, int d) {
        int left = n;
        int right = n;
        ArrayList<int[]> leftInfo = new ArrayList<>();
        ArrayList<int[]> rightInfo = new ArrayList<>();
        int leftWay = d;
        int rightWay = d;

        while (left - 1 >= 0 && checkDifferent(left, -1)) {
            left--;
            leftWay *= -1;
            leftInfo.add(new int[]{left, leftWay});

        }

        while (right + 1 <= 3 && checkDifferent(right, 1)) {
            right++;
            rightWay *= -1;
            rightInfo.add(new int[]{right, rightWay});

        }

        applyRotate(leftInfo);
        applyRotate(rightInfo);

        cycles[n].top = checkRange(cycles[n].top - d);
    }

    public static void applyRotate(ArrayList<int[]> info) {
        for (int[] array: info) {
            int temp = cycles[array[0]].top - array[1];
            cycles[array[0]].top = checkRange(temp);
        }
    }

    public static boolean checkDifferent(int n, int d) {
        int edge = checkRange(cycles[n].top + 2 * d);
        int otherEdge = checkRange(cycles[n + d].top - 2 * d);

        if (cycles[n].data[edge] != cycles[n + d].data[otherEdge]) {
            return true;
        }

        return false;
    }

    public static int checkRange(int edge) {
        if (edge < 0) {
            edge += 8;
        } else if (edge > 7) {
            edge -= 8;
        }
        return edge;
    }

    public static int calculateScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            int idx = cycles[i].top;
            if (cycles[i].data[idx] == 1) {
                score += Math.pow(2, i);
            }
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;

        cycles = new Cycle[4];
        for (int i = 0; i < 4; i++) {
            input = br.readLine();
            Cycle cycle = new Cycle();
            int[] nums = new int[8];
            for (int j = 0; j < 8; j++) {
                nums[j] = Character.getNumericValue(input.charAt(j));
            }
            cycle.data = nums;
            cycles[i] = cycle;
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            rotate(n - 1, d);
        }

        int score = calculateScore();
        System.out.print(score);
    }
}