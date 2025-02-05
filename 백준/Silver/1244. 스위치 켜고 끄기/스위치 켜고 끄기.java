import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] switches;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int switchCnt = Integer.parseInt(br.readLine());
        switches = new int[switchCnt];

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            switches[idx++] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (student == 1) { // 남학생인 경우
                boy(num);
            }
            else { // 여학생인 경우
                girl(num);
            }
        }

        printAnswer();
    }

    private static void boy(int num) {
        int start = num - 1;
        while (start < switches.length) {
            switches[start] = (switches[start] + 1) % 2;
            start += num;
        }
    }

    private static void girl(int num) {
        num--;
        int start = num;
        int end = num;
        while (start >= 0 && end < switches.length && switches[start] == switches[end]) {
            switches[start] = (switches[start] + 1) % 2;
            if (start != end) {
                switches[end] = (switches[end] + 1) % 2;
            }
            start -= 1;
            end += 1;
        }
    }

    private static void printAnswer() {
        int cnt = 0;
        Iterator<Integer> answers = Arrays.stream(switches).iterator();
        do {
            System.out.print(answers.next());
            cnt++;
            if (cnt % 10 == 0) System.out.println();
            else if (answers.hasNext()) System.out.print(" ");
        } while (cnt < switches.length);

    }
}
