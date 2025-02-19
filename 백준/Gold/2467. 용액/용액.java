import java.io.*;
import java.util.*;

class Liquid implements Comparable<Liquid> {
    int value;
    int abs;

    public Liquid(int value) {
        this.value = value;
        this.abs = Math.abs(value);
    }

    @Override
    public int compareTo(Liquid o) {
        if (this.abs == o.abs) {
            return this.value - o.value;
        }
        return this.abs - o.abs;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Liquid[] liquids = new Liquid[n];
        for (int i = 0; i < n; i++) {
            liquids[i] = new Liquid(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(liquids);
        int answer = Integer.MAX_VALUE;
        int answerVal1 = 0;
        int answerVal2 = 0;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(liquids[i].value + liquids[i + 1].value) < answer) {
                answer = Math.abs(liquids[i].value + liquids[i + 1].value);
                answerVal1 = liquids[i].value;
                answerVal2 = liquids[i + 1].value;
            }
        }
        System.out.println(Math.min(answerVal1, answerVal2) + " " + Math.max(answerVal1, answerVal2));
    }
}
